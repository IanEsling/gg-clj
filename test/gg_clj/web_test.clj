(ns gg-clj.web-test
	(:use gg-clj.web)
  	(:use gg-clj.web-pages)
  	(:use midje.sweet))


(fact "race day urls parsed from website"
	(count (get-race-urls urls-page)) => 27)
