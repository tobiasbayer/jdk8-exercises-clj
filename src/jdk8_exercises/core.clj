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
  (->> coll
      (drop start)
      (take lines-to-join)
      (reduce #(str %1 %2))))

(defn longest-line-length [coll]
  (count (reduce #(if (> (count %1) (count %2))
                        %1
                        %2) coll)))

(defn collect-words [coll]
  (->> coll
       (mapcat #(clojure.string/split % #"\W+"))
       (filter #(> (count %) 0))))

(defn collect-words-lowercased-sorted [coll]
  (-> coll
      (collect-words)
      (lowercase-all)
      (sort)))

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

(defn group-by-word-length [coll]
  (group-by count (collect-words coll)))

(defn- init-map [coll]
  (reduce #(assoc %1 %2 0) {} coll))

(defn group-by-occurences [coll]
  (let [collected (collect-words coll)]
    (reduce #(assoc %1 %2 (inc (%1 %2)))
            (init-map collected)
            collected)))

(defn- update-values [m f & args]
  (reduce (fn [r [k v]] (assoc r k (apply f v args))) {} m))

(defn- group-by-first-letter [coll]
  (group-by #(str (.charAt % 0)) coll))

(defn group-by-first-letter-and-length [coll]
  (update-values (group-by-first-letter (collect-words coll))
                 group-by-word-length))


