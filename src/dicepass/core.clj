(ns dicepass.core)

(defn throw-dice 
  "Throws a `n`-faces dice."
  [n]
  (inc (rand-int n)))

(defn throw-dices 
  "Throws `num` dices with `faces`... faces."
  [num faces]
  (repeatedly num #(throw-dice faces)))