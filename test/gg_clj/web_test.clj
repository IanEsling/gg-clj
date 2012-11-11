(ns gg-clj.web-test
	(:use gg-clj.web)
  	(:use midje.sweet)
  )


(fact "race day urls parsed from website"
	(< 0 (count (get-race-urls))) => true)
