(ns gg-clj.mail
  (:use [gg-clj.core :as core])
  (:use postal.core)
  (:use hiccup.core)
  (:use clojure.tools.logging)
  (:use clj-logging-config.log4j))

(set-logger! :level :info
    	     :additivity false
        	 :pattern "%p - %m%n"
             )

(defn lay-races-html
  "HTML for lay betting email"
  [races title]
  (info (str "getting html for layraces: " races))
    (html [:html 
            (html [:head])
            (html [:body {:style
                          "font-family: Helvetica, Arial, sans-serif; background-color: #90ee90"
                          }
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

(defn back-races-html
  "HTML for back betting email"
  [races title]
  (info (str "getting html for back races: " races))
    (html [:html 
            (html [:head])
            (html [:body {:style
                          "font-family: Helvetica, Arial, sans-serif; background-color: #4BC2EE"
                          }
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
                             ]
                           ]
                          ]])))])]))

(defn send-lay-races
  "send lay bet email for given races to given email addresses"
  [races emails]
  (let [content (lay-races-html (core/calculate-lay-bet-races races) "Lay Bet races for today:")]
    (doseq [e emails]
      (info (str "sending lay races to " e))
      (send-message ^{:host "smtp.sendgrid.net"
                      :user (System/getenv "SENDGRID_USERNAME")
                      :pass (System/getenv "SENDGRID_PASSWORD")}
                    {:from "geegees@geegees.com"
                     :to e
                     ;;:to "ian.esling@gmail.com"
                     :subject "Today's GeeGees Lay Betting Tips"
                     :body [{:type "text/html"
                             :content content}]}))))

(defn send-back-races
  "send back bet email for given races to given email addresses"
  [races emails]
  (let [content (back-races-html (take 10 (core/calculate-back-bet-races races)) "Back Bet races for today:")]
    (doseq [e emails]
      (info (str "sending back races to " e))
      (send-message ^{:host "smtp.sendgrid.net"
                      :user (System/getenv "SENDGRID_USERNAME")
                      :pass (System/getenv "SENDGRID_PASSWORD")}
                    {:from "geegees@geegees.com"
                     :to e
                     ;;:to "ian.esling@gmail.com"
                     :subject "Today's GeeGees Back Betting Tips"
                     :body [{:type "text/html"
                             :content content}]}))))