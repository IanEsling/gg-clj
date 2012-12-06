(ns gg-clj.app-test
  (:use gg-clj.app)
  (:use midje.sweet))

(def results [{:race_date 123455 :finish 9} {:race_date 123456 :finish 1}{:race_date 123457 :finish :2}{:race_date 123458 :finish 3}])

(fact "running totals calculated for any race"
      (running-total results running-lay-total) => (contains [{:race_date 123455 :total 0.95M}
                                                              {:race_date 123456 :total -1.05M}
                                                              {:race_date 123457 :total -0.10M}
                                                              {:race_date 123458 :total 0.85M}])
      (running-total results running-back-total) => (contains [{:race_date 123455 :total -1.0M}
                                                               {:race_date 123456 :total 0.5M}
                                                               {:race_date 123457 :total -0.5M}
                                                               {:race_date 123458 :total -1.5M}])    
      )

(fact "chart data for running totals"
      (chart-data (running-total results running-lay-total)) => "0.95,-1.05,-0.10,0.85"
      (chart-data (running-total results running-back-total)) => "-1.0,0.5,-0.5,-1.5"      
      )