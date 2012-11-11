(ns gg-clj.core
	(:use gg-clj.web)
  (:import 	[org.jsoup Jsoup]
   			[org.jsoup.nodes Document]))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))


(defn- connection []
  (Jsoup/connect "http://betting.racingpost.com/horses/cards"))

(defn- page []
  (.get (connection)))

(defn get-all-race-urls []
	(get-race-urls page))