(ns gg-clj.mail
  (:use [clojure.string :exclude [reverse]])
  (:use postal.core)
  (:use hiccup.core)
  (:use clojure.tools.logging)
  (:use clj-logging-config.log4j))

(set-logger! :level :info
    	     :additivity false
        	 :pattern "%p - %m%n"
             )


(defn if-bettable [race f]
  (if (:bettable race)
    (f race)
    race))

(defn numeric-odds [odds]
  (let [components (for [s (split (replace odds "Evs" "1/1") #"/")] (read-string s))]
        	(/ (first components) (second components))))

(defn add-bettable [race]
  (info (str "working out if bettable: " race))
      (assoc race :bettable (< 0 (count
									(filter #(let [odds (numeric-odds %)]
										(and (>= 2 odds) (<= 1 odds)))
									(map #(:odds %) (:horses race)))))))

(defn sorted-odds [race]
  (sort (map #(numeric-odds %) (map #(:odds %) (:horses race)))))

(defn add-difference-in-odds [race]
  (let [odds (sorted-odds race)
    	first (first odds)
        second (second odds)]

  	(assoc race :odds-diff (- second first))))

(defn remove-non-favourites [race]
	(assoc race :horses (filter 
                         #(= (first (sorted-odds race)) (numeric-odds (:odds %))) 
                                (:horses race))))

(defn magic-number [horse race]
  (info (str "calculating magic number..." horse race))
    	(- 
         (+ (:odds-diff race)(:tips horse))	
           (:runners race)))

(defn add-magic-number [race]
  (assoc race :horses
	(for [horse (:horses race)]
		(assoc horse :magic-number (magic-number horse race)))))

(defn get-lowest-magic-number [race]
    (assoc race :lowest-magic-number 
      (reduce (fn [i j] (if (< i j) i j)) 100 
            (map :magic-number (:horses race)))))

(defn emailable-race [race]
  (info (str "getting emailable race: " race))
	(-> (add-bettable race) 
        (if-bettable add-difference-in-odds) 
        (if-bettable remove-non-favourites) 
        (if-bettable add-magic-number) 
        (if-bettable get-lowest-magic-number)))

(def magic-number-comparator (comparator (fn [i j] (< i j))))

(defn emailable-races [races]    
    (sort-by :lowest-magic-number magic-number-comparator        
      (filter #(:bettable %)
              (for [race races]
                (emailable-race race)))))

(defn races-html [races]
  (info (str "getting html for races: " races))
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
                   "Bettable races for today:"])
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
                                  (str "Number of runners: " (:runners r))]
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
                          ]])))
       ])]))

(defn send-races [races]
  (info (str "sending races: " (emailable-races races)))
  (send-message ^{:host "smtp.sendgrid.net"
                  :user (System/getenv "SENDGRID_USERNAME")
                  :pass (System/getenv "SENDGRID_PASSWORD")}
                {:from "geegees@geegees.com"
                 ;;:to ["ian.esling@gmail.com" "pesling@gmail.com" "aliciales@esling.me.uk"]
                 :to "ian.esling@gmail.com"
                 :subject "Today's GeeGees Tips"
                 :body [{:type "text/html"
                         :content (races-html (emailable-races races))}]}))