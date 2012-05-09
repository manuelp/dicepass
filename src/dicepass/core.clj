(ns dicepass.core
  (:require [dicepass.dictionary :as dict])
  (:use [clojure.string :only [join]])
  (:gen-class))

(defn throw-dice 
  "Throws a `n`-faces dice."
  [n]
  (inc (rand-int n)))

(defn throw-dices 
  "Throws `num` dices with `faces`... faces."
  [num faces]
  (repeatedly num #(throw-dice faces)))

(defn generate-word
  [dict]
  (let [key (apply str (throw-dices 5 6))]
    (get dict key)))

(defn generate-words
  [n filename]
  (let [dict (dict/create-dictionary filename)]
    (join " " (repeatedly n #(generate-word dict)))))

(defn -main
  [& args]
  (println (generate-words 5 (first args))))