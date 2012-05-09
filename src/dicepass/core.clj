(ns dicepass.core
  (:require [dicepass.dictionary :as dict]
            [crypto.random :as random])
  (:use [clojure.string :only [join]])
  (:import [java.util Arrays])
  (:gen-class))

(defn throw-dice 
  "Throws a `n`-faces dice, max 255."
  [n]
  (let [ring (cycle (range 1 (inc n)))
        num (first (random/bytes 1))]
    (nth ring (if (> num 0)
                num
                (* -1 num)))))

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