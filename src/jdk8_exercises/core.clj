(ns jdk8_exercises.core)

(def word-list ["every" "problem" "in" "computer" "science"
                "can" "be" "solved" "by" "adding" "another"
                "level" "of" "indirection"])

(def file-content
  (with-open [rdr (clojure.java.io/reader "resources/SonnetI.txt")]
    (doall (line-seq rdr))))

(defn print-all [coll]
  (apply println coll))

(defn find-even-length [coll]
  (filter #(even? (.length %)) coll))

(defn uppercase-all [coll]
  (map #(.toUpperCase %) coll))

(defn count-lines [coll]
  (count coll))

