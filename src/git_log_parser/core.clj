(ns git-log-parser.core
  (:require [clojure.java.io :as io])
  (:gen-class :main true))


(defn -main [& args]
  (with-open  [input (io/reader *in*)
               output (io/writer *out*)]
    (do
      (.write
       output
       (apply str (line-seq input))))))

