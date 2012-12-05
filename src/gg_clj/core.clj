(ns gg-clj.core
	(:gen-class)
	(:use [ gg-clj.web :as web])
  	(:use [ gg-clj.db :as db])
  	(:use [ gg-clj.mail :as mail])
  	(:use clojure.tools.logging)
  	(:use clj-logging-config.log4j)
        (:import [org.joda.time.format DateTimeFormat])
        (:import [org.joda.time LocalDate]))

(set-logger! :level :info
    	     :additivity false
        	 :pattern "%p - %m%n"
                 )

