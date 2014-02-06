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

(defn lowercase-all [coll]
  (map #(.toLowerCase %) coll))

(defn count-lines [coll]
  (count coll))

(defn join-lines [start lines-to-join coll]
  (reduce #(str %1 %2) (take lines-to-join (drop start coll))))

(defn longest-line-length [coll]
  (count (reduce #(if (> (count %1) (count %2))
                        %1
                        %2) coll)))

(defn collect-words [coll]
  (filter #(> (count %) 0)
          (mapcat #(clojure.string/split % #"\W+") coll)))

(defn collect-words-lowercased-sorted [coll]
  (sort (lowercase-all (collect-words coll))))

(defn- compare-by-length-lex [x y]
  (let [cx (count x)
        cy (count y)]
    (if (= cx cy)
      (< (.compareTo x y) 0)
      (< cx cy))))

(defn collect-words-lowercased-sorted-by-length-unique [coll]
  (distinct (sort (comparator compare-by-length-lex)
                  (lowercase-all (collect-words coll)))))

(defn group-by-word-length [coll]
  (group-by count (collect-words coll)))

