(ns git-log-parser.core
  (:require [clojure.java.io :as io])
  (:gen-class :main true))


(defn -main [& args]
  (with-open  [stream
               (io/reader (. System in))]
    (do
      (println
       (apply str (line-seq stream))))))

