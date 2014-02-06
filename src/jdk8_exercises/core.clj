(ns jdk8_exercises.core)

(def word-list ["every" "problem" "in" "computer" "science"
                "can" "be" "solved" "by" "adding" "another"
                "level" "of" "indirection"])

(def file-content
  (with-open [rdr (clojure.java.io/reader "resources/SonnetI.txt")]
    (doall (line-seq rdr))))


;; Exercise 1
(defn print-all [coll]
  (apply println coll))

;; Exercise 2
(defn find-even-length [coll]
  (filter #(even? (.length %)) coll))

;; Exercise 3
(defn uppercase-all [coll]
  (map #(.toUpperCase %) coll))

;; Exercise 4
(defn count-lines [coll]
  (count coll))

;; Exercise 5
(defn join-lines [start lines-to-join coll]
  (->> coll
      (drop start)
      (take lines-to-join)
      (reduce #(str %1 %2))))

;; Exercise 6
(defn longest-line-length [coll]
  (count (reduce #(if (> (count %1) (count %2))
                        %1
                        %2) coll)))

;; Exercise 7
(defn collect-words [coll]
  (->> coll
       (mapcat #(clojure.string/split % #"\W+"))
       (filter #(> (count %) 0))))

;; Exercise 8
(defn- lowercase-all [coll]
  (map #(.toLowerCase %) coll))

(defn collect-words-lowercased-sorted [coll]
  (-> coll
      (collect-words)
      (lowercase-all)
      (sort)))

;; Exercise 9
(defn- compare-by-length-lex [x y]
  (let [cx (count x)
        cy (count y)]
    (if (= cx cy)
      (< (.compareTo x y) 0)
      (< cx cy))))

(defn collect-words-lowercased-sorted-by-length-unique [coll]
  (->> coll
       (collect-words)
       (lowercase-all)
       (sort (comparator compare-by-length-lex))
       (distinct)))

;; Exercise 10
(defn group-by-word-length [coll]
  (group-by count (collect-words coll)))

;; Exercise 11
(defn- init-map [coll]
  (reduce #(assoc %1 %2 0) {} coll))

(defn group-by-occurences [coll]
  (let [collected (collect-words coll)]
    (reduce #(assoc %1 %2 (inc (%1 %2)))
            (init-map collected)
            collected)))

;; Exercise 12
(defn- update-values [m f & args]
  (reduce (fn [r [k v]] (assoc r k (apply f v args))) {} m))

(defn- group-by-first-letter [coll]
  (group-by #(str (.charAt % 0)) coll))

(defn group-by-first-letter-and-length [coll]
  (update-values (group-by-first-letter (collect-words coll))
                 group-by-word-length))


