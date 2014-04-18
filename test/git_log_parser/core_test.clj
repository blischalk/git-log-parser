(ns git-log-parser.core-test
  (:require [clojure.test :refer :all]
            [git-log-parser.core :refer :all]
            [midje.sweet :refer :all]))

(facts "A test"
  (fact "Should pass"
    (is (= 1 1))))
