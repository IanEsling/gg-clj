(ns gg-clj.app-test
  (:use gg-clj.app)
  (:use gg-clj.page)
  (:use midje.sweet))

(def race_results [{:race_date 123455 :finish [9]} {:race_date 123456 :finish [1]}{:race_date 123457 :finish [2]}{:race_date 123458 :finish [3]}])

(fact "running totals calculated for any race"
      (running-total race_results running-lay-total) => (contains [{:race_date 123455 :total 0.95M :finishes nil}
                                                              {:race_date 123456 :total -1.05M :finishes nil}
                                                              {:race_date 123457 :total -0.10M :finishes nil}
                                                              {:race_date 123458 :total 0.85M :finishes nil}])
      (running-total race_results running-back-total) => (contains [{:race_date 123455 :total -1.0M :finishes nil}
                                                               {:race_date 123456 :total 0.5M :finishes nil}
                                                               {:race_date 123457 :total -0.5M :finishes nil}
                                                               {:race_date 123458 :total -1.5M :finishes nil}])    
      )

(fact "chart data for running totals"
      (chart-data (running-total race_results running-lay-total)) => "{y : 0.95, finishes : []},{y : -1.05, finishes : []},{y : -0.10, finishes : []},{y : 0.85, finishes : []}"
      (chart-data (running-total race_results running-back-total)) => "{y : -1.0, finishes : []},{y : 0.5, finishes : []},{y : -0.5, finishes : []},{y : -1.5, finishes : []}"      
      )