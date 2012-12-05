(ns gg-clj.app
  (:use [gg-clj.db :as db])
  (:use [gg-clj.mail :as mail])
  (:use hiccup.core)
  (:use [compojure.core :only [defroutes GET]])
  (:use ring.middleware.reload)
  (:require [ring.adapter.jetty :as ring])
  (:require [compojure.route :as route]))
 
(defn index-html
  "HTML for lay betting page"
  [races title]
    (html [:html 
            (html [:head [:link {:href "/css/gg.css" :media "screen" :rel "stylesheet" :type "text/css"}]])
            (html [:body
            (html [:div {:style "text-align: center;"}
                   (html [:img {:style "padding-top: 15px;"
                          :src "https://s3.amazonaws.com/ianesling/dad.jpg"
                          }])])
            (html [:h1 {:style "font-size: 24pt; padding-top: 10px; text-align: center;width: 80%;margin: auto;"}
                   "Les of Profit"])
            (html [:h2 {:style "font-size: 20pt;text-align: center;width: 80%;margin: auto;"}
                   title])
                   (html (for [r races]
                    (html [:table {:style "width: 80%;text-align: center;border-top: solid 2px black;margin: auto;"}
                         [:tr
                            [:td {:style "text-align: right;width: 50%"}
                                [:div
                                 [:p {:style "font-size: 24pt;"}
                                  (:time r)]
                                 [:p {:style "font-size: 14pt;"}
                                  (:venue r)]
                                 [:p {:style "font-size: 11pt;"}
                                  (str "Number of runners: " (:number_of_runners r))]
                                 ]
                             ]
                          [:td {:style "text-align: center;width: 50%;"}
                             [:div 
                              (for [horse (:horses r)]
                                (html
                                [:p (str (:name horse) " - " (:odds horse))]
                                 [:p {:style "font-weight: bold;font-size: 14pt;"}
                                  (:magic-number horse)]))
                              [:p (if (> (:odds-diff r) 3)
                                    {:style "font-weight: bold;color: red;"}
                                    {:style "font-weight: bold;"}) 
                               (str  "Odds Difference - " (:odds-diff r))]
                             ]
                           ]
                          ]])))])]))

(defroutes routes
  (GET "/"
       []
       (if (db/race-day-today-exists)
         (mail/lay-races-html (:races (db/get-race-day)) "Today's Lay Bets")
         (index-html (mail/emailable-lay-bet-races (:races (db/get-latest-race-day))) "Latest Lay Bets")))
  (route/files "/" {:root "public"}))

(defn start []
  (ring/run-jetty (wrap-reload #'routes '(gg-clj.app gg-clj.mail gg-clj.web gg-clj.db)) {:port 8080 :join? false}))
