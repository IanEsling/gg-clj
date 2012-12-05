(ns gg-clj.app-test
  (:use gg-clj.app)
  (:use midje.sweet))

(def race-day-win {:races [{:venue "Venue1" :time "12:34" :number_of_runners 2 :horses [{:name "h1" :odds "2/1" :tips 5 :finish 1} {:name "h2" :odds "3/1" :tips 3 :finish 2}]}]})

(fact "winner or loser calculated for any race day"
      (winning-lay-bet (calculate-race-day race-day-win)) => true
      )