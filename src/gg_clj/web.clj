(ns gg-clj.web
  (:use clojure.set)
  (:import 	[org.jsoup Jsoup]
   			[org.jsoup.nodes Document]))

(defn- connection []
  (Jsoup/connect "http://betting.racingpost.com/horses/cards"))

(defn- page []
  (.get (connection)))

(defn- get-anchor-href [coll a]
  (conj coll (.attr a "href")))

(defn- get-race-urls-from-selector [page css-selector]
	(reduce get-anchor-href #{}
	(.select page css-selector)))

(defn get-race-urls []
	(apply union (for [css-selector ["div.leftColumn table strong a" 
                                  "div.rightColumn table strong a"]]
  					(get-race-urls-from-selector (page) css-selector))))
