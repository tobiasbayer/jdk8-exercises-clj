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

(fact "it counts the number of lines in the file"
  (count-lines file-content) => 14)

(fact "it joins lines 3 and 4"
  (join-lines 2 2 file-content) => "But as the riper should by time decease,His tender heir might bear his memory:")

(fact "it finds the length of the longest line"
  (longest-line-length file-content) => 53)

(fact "it collects all words into one list"
  (collect-words file-content) => [ "From"  "fairest"  "creatures"  "we"  "desire"  "increase"
                                    "That"  "thereby"  "beauty"  "s"  "rose"  "might"  "never"  "die"
                                    "But"  "as"  "the"  "riper"  "should"  "by"  "time"  "decease"
                                    "His"  "tender"  "heir"  "might"  "bear"  "his"  "memory"  "But"
                                    "thou"  "contracted"  "to"  "thine"  "own"  "bright"  "eyes"
                                    "Feed"  "st"  "thy"  "light"  "s"  "flame"  "with"  "self"
                                    "substantial"  "fuel"  "Making"  "a"  "famine"  "where"
                                    "abundance"  "lies"  "Thy"  "self"  "thy"  "foe"  "to"  "thy"
                                    "sweet"  "self"  "too"  "cruel"  "Thou"  "that"  "art"  "now"
                                    "the"  "world"  "s"  "fresh"  "ornament"  "And"  "only"  "herald"
                                    "to"  "the"  "gaudy"  "spring"  "Within"  "thine"  "own"  "bud"
                                    "buriest"  "thy"  "content"  "And"  "tender"  "churl"  "mak"
                                    "st"  "waste"  "in"  "niggarding"  "Pity"  "the"  "world"  "or"
                                    "else"  "this"  "glutton"  "be"  "To"  "eat"  "the"  "world"  "s"
                                    "due"  "by"  "the"  "grave"  "and"  "thee"])
