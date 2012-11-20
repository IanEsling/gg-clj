(ns gg-clj.mail-test
  (:use gg-clj.mail)
  (:use midje.sweet))

(def bettable-race {:venue "V" 
                    :time "12.34" 
                    :runners 3
                    :horses '({:name "h1"
                               :odds "2/1"
                               :tips 2
                               }
                              {:name "h2"
                               :odds "3/1"
                               :tips 1
                               })})


(fact "should calculate if race is bettable"
	(emailable-race bettable-race) => (contains {:bettable true}))
