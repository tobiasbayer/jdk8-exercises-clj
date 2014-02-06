(ns jdk8_exercises.t-core
  (:use midje.sweet)
  (:use [jdk8_exercises.core]))

(fact "it prints out all the words"
  (print-all word-list) => anything)

(fact "it uppercases all words"
  (uppercase-all word-list) => ["EVERY" "PROBLEM" "IN" "COMPUTER" "SCIENCE"
                                 "CAN" "BE" "SOLVED" "BY" "ADDING" "ANOTHER"
                                 "LEVEL" "OF" "INDIRECTION"])

(fact "it finds all even-length words"
  (find-even-length word-list) => ["in" "computer" "be" "solved" "by" "adding" "of"])
