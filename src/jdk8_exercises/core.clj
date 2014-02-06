(ns jdk8_exercises.core
  (:use midje.sweet))

(def word-list ["every" "problem" "in" "computer" "science"
                "can" "be" "solved" "by" "adding" "another"
                "level" "of" "indirection"])

(def file-content
  (with-open [rdr (clojure.java.io/reader "resources/SonnetI.txt")]
    (doall (line-seq rdr))))

(defn print-all []
  (apply println word-list))

(fact "prints out all the words"
  (print-all))

