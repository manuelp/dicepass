(ns dicepass.dictionary
  (:use [clojure.string :only [split]]))

(defn create-dictionary
  [filename]
  (letfn [(extract-entries []
            (re-seq #"[0-9]{5}\t\w+" (slurp filename)))]
    (loop [coll (map #(split % #"\t") (extract-entries))
          dict {}]
     (if (empty? coll)
       dict
       (recur (rest coll) (assoc dict (ffirst coll) (second (first coll))))))))