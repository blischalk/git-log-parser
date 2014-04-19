(ns git-log-parser.core
  (:require [clojure.java.io :as io]
            [instaparse.core :as insta])
  (:gen-class :main true))

(def commit
  (insta/parser "<COMMITS> = <NEWLINE*> COMMIT+
                              SHA = #'[a-f0-9]+'
                              COMMIT = (<'commit '> SHA <NEWLINE>
                                       AUTHOR <NEWLINE>
                                       DATE <NEWLINE>
                                       <NEWLINE>
                                       BODY)
                              BODY = SPACE+ STORY <COLON?> SPACE BODY-LINE+
                              STORY = <'PD-'> #'\\d+'
                              BODY-LINE = <SPACE*> (WORD (SPACE+ WORD)*)? <NEWLINE>
                              <AUTHORNAME> = #'[a-zA-Z\\- \\.]+'
                              AUTHOR = <'Author:' SPACE+> WORD (SPACE WORD)*
                              <WORD> = #'\\S+' | HAPPINESS
                              HAPPINESS = <'h:'> #'[0-5]'
                              <SPACE> = <' '>
                              <COLON> = ':'
                              DATE = <'Date:' SPACE+> WORD (SPACE WORD)*
                              NEWLINE = '\n'"))

(defn -main [& args]
  (with-open  [input (io/reader *in*)
               output (io/writer *out*)]
    (do
      (.write
       output
       (apply str (commit (apply str (line-seq input))))))))
