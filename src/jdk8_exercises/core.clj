(ns jdk8_exercises.core)

(def file-content
  (with-open [rdr (clojure.java.io/reader "resources/SonnetI.txt")]
    (doall (line-seq rdr))))



