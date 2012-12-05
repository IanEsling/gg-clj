(ns gg-clj.app
  (:use [gg-clj.db :as db])
  (:use [gg-clj.mail :as mail])
  (:use [compojure.core :only [defroutes GET]])
  (:require [ring.adapter.jetty :as ring]))

(defroutes routes
  (GET "/"
       []
       (if (db/race-day-today-exists)
         (mail/lay-races-html (:races (db/get-race-day)) "Today's Lay Bets")
         (mail/lay-races-html (:races (db/get-latest-race-day)) "Latest Lay Bets"))))

(defn start []
  (ring/run-jetty #'routes {:port 8080 :join? false}))

