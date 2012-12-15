(ns gg-clj.page
  (:use hiccup.core)
  (:use hiccup.form))

(defn link-index []
  [:li [:a {:href "/"} "Home"]])

(defn link-lay []
  [:li [:a {:href "/lay"} "Tweak Lay Betting"]])

(defn link-back []
  [:li [:a {:href "/back"} "Tweak Back Betting"]])

(defn subs-miss-end
  "returns a string with the last char substringed out"
  [s]
  (if (< 0 (count s)) (subs s 0 (- (count s) 1)) s))

(defn finishes [results]
  (apply str
         (for [finish (:finishes results)]
           (str "{"
                "finish : " (:finish finish) ","
                "name : '" (:name finish) "'"
                ","
                "venue : '" (:venue finish) "'"
                ",time : '" (:time finish) "'"
                ",mn : '" (:magic-number finish) "'"
                ",odds : '" (:odds finish) "'"
                "},"))))

(defn first-race-date-in-millis
  "gets earliest race date in millis"
  [race-day-results]
  (reduce (fn [t n]
            (prn t n)
            (if (< t n) t n)) (.getTime (java.util.Date.))
            (map :race_date race-day-results)))

(defn chart-data
  "mung the result data into a comma separated list for the chart data in the HTML page"
  [race-day-results]

  (def data (apply str (for [result race-day-results]
                         (str "{y : " (:total result)
                              ", finishes : [" (subs-miss-end (finishes result))
                              "]},"))))
  (prn "chart data:" data)
  (subs-miss-end data))

(defn chart-series
  "produce the series for the chart configuration, produce a different series for each running total passed in"
  [running-totals]
  (subs-miss-end (apply str
                        (for [running-total running-totals]
                          (str "{
                name: '"
                               (:title running-total)
                               "',
                pointInterval: 24 * 3600 * 1000,
                pointStart: "
                               (first-race-date-in-millis (:value running-total))
                               ",
                data: ["
                               (chart-data (:value running-total))
                               "]},"
                               )))))

(defn form
  ([] (form 1 1 1 0))
  ([map] (form (:odds-diff map) (:tips map) (:runners map) (:other-tips map) (:odds-diff-calc map)))
  ([odds-diff tips runners other-tips] (form odds-diff tips runners other-tips "second"))
  ([odds-diff tips runners other-tips odds-diff-calc]
     (form-to [:post "/lay"]
              "Magic number for favourite in new lay bets:"
              [:br]              
              (text-field {:size 5 :maxlength 6} "odds-diff" odds-diff)
              (label "odds-diff" " x odds difference between 1st and 2nd favourite + ")
              [:br]
              (text-field {:size 5 :maxlength 6} "tips" tips)
              (label "tips" " x number of tips on favourite - ")
              [:br]
              (text-field {:size 5 :maxlength 6} "runners" runners)
              (label "runners" " x Number of Runners - ")
              [:br]
              (text-field {:size 5 :maxlength 6} "other-tips" other-tips)
              (label "other-tips" " x number of tips on other horses ")
              [:br]
              (label "odds-diff-calc-second" "Use Second Favourite for Odds Difference")
              (radio-button "odds-diff-calc" (= "second" odds-diff-calc) "second")
              [:br]
              (label "odds-diff-calc-third" "Use Third Favourite for Odds Difference")
              (radio-button "odds-diff-calc" (= "third" odds-diff-calc) "third")
              [:br]
              (submit-button "Calculate" ))))

(defn index
  "HTML for betting page"
  ([running-totals links] (index running-totals links nil))
  ([running-totals links form-f]
     (html [:html
            (html [:head [:link {:href "/css/gg.css" :media "screen" :rel "stylesheet" :type "text/css"}]
                   [:script {:type "text/javascript" :src "http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"}]
                   [:script {:type "text/javascript" :src "/js/highcharts.js"}]
                   [:script {:type "text/javascript"}
                    (str "$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                marginRight: 130,
                marginBottom: 25,
                type: 'spline'
            },
            title: {
                text: 'Betting Points',
                x: -20 //center
            },
            subtitle: {
                text: '',
                x: -20
            },
            tooltip: {
                formatter: function() {
                var s = '';
                for (var i=0,len=this.point.finishes.length; i<len; i++)
                {
                   s = s + this.point.finishes[i].time + ' ' + this.point.finishes[i].venue + '<br/>'
+ this.point.finishes[i].name + '<b> finished: ' + this.point.finishes[i].finish + '</b><br/>magic number: ' + this.point.finishes[i].mn + ' <br/>odds: ' + this.point.finishes[i].odds + '<br/>'
                }
                if (s == '')
                {
                  return 'No Bet.';
                } else
                {
                return s;
                }
             }
            },
            xAxis: {
                type: 'datetime'
                },
            yAxis: {
                title: {
                    text: 'Number of Points'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: 0,
                y: 0,
                borderWidth: 0
            },
            series: ["
                         (chart-series running-totals)
                         "]});
    });

});")]])
            (html [:body
                   [:div {:id "links"}
                    [:ul
                     (map #(%) links)]]
                   [:div {:id "container"}]
                   [:div {:id "form"}
                    (if-not (nil? form-f) (form-f))]
                   ])

            ])))
