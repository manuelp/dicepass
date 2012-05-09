(defproject dicepass "0.1.0-SNAPSHOT"
  :description "Diceware-based passphrases generator."
  :url "https://github.com/manuelp/dicepass"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-swank "1.4.4"]]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [crypto-random "1.1.0"]]
  :main dicepass.core)
