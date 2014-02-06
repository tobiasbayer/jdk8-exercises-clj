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

(fact "it collects all words lowercased and in alphabetical order"
  (collect-words-lowercased-sorted file-content) => ["a"  "abundance"  "and"  "and"  "and"  "art"  "as"  "be"
                                        "bear"  "beauty"  "bright"  "bud"  "buriest"  "but"  "but"
                                        "by"  "by"  "churl"  "content"  "contracted"  "creatures"
                                        "cruel"  "decease"  "desire"  "die"  "due"  "eat"  "else"
                                        "eyes"  "fairest"  "famine"  "feed"  "flame"  "foe"  "fresh"
                                        "from"  "fuel"  "gaudy"  "glutton"  "grave"  "heir"  "herald"
                                        "his"  "his"  "in"  "increase"  "lies"  "light"  "mak"
                                        "making"  "memory"  "might"  "might"  "never"  "niggarding"
                                        "now"  "only"  "or"  "ornament"  "own"  "own"  "pity"
                                        "riper"  "rose"  "s"  "s"  "s"  "s"  "self"  "self"  "self"
                                        "should"  "spring"  "st"  "st"  "substantial"  "sweet"
                                        "tender"  "tender"  "that"  "that"  "the"  "the"  "the"
                                        "the"  "the"  "the"  "thee"  "thereby"  "thine"  "thine"
                                        "this"  "thou"  "thou"  "thy"  "thy"  "thy"  "thy"  "thy"
                                        "time"  "to"  "to"  "to"  "to"  "too"  "waste"  "we"  "where"
                                        "with"  "within"  "world"  "world"  "world"])

(fact "it collects all unique words lowercased and sorted by length"
  (collect-words-lowercased-sorted-by-length-unique file-content) => [ "a" "s" "as" "be" "by" "in" "or" "st" "to" "we"
                                                             "and" "art" "bud" "but" "die" "due" "eat" "foe" "his"
                                                             "mak" "now" "own" "the" "thy" "too" "bear" "else"
                                                             "eyes" "feed" "from" "fuel" "heir" "lies" "only"
                                                             "pity" "rose" "self" "that" "thee" "this" "thou"
                                                             "time" "with" "churl" "cruel" "flame" "fresh" "gaudy"
                                                             "grave" "light" "might" "never" "riper" "sweet" "thine"
                                                             "waste" "where" "world" "beauty" "bright" "desire"
                                                             "famine" "herald" "making" "memory" "should" "spring"
                                                             "tender" "within" "buriest" "content" "decease"
                                                             "fairest" "glutton" "thereby" "increase" "ornament"
                                                             "abundance" "creatures" "contracted" "niggarding"
                                                             "substantial"])

(fact "it groups the words by length"
  (let [result (group-by-word-length file-content)]
    (count (result 7)) => 6
    (result 8)  => ["increase" "ornament"]
    (result 9)  => ["creatures" "abundance"]
    (result 10) => ["contracted" "niggarding"]
    (result 11) => ["substantial"]
    (result 12) => nil))

