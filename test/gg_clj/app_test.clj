(ns gg-clj.app-test
  (:use gg-clj.core)
  (:use midje.sweet))

(def race-day-win {:races [{:venue "Venue1" :time "12:34" :number_of_runners 2 :horses [{:name "h1" :odds "2/1" :tips 5 :finish 1} {:name "h2" :odds "3/1" :tips 3 :finish 2}]}]})

(defn winning-lay-bet [race]
  (not= 1 (:finish (first (:horses race)))))

(fact "winner or loser calculated for any race"
      (winning-lay-bet (first (calculate-lay-bet-races (:races race-day-win)))) => false
      )