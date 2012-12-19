(ns strftime
  #^{ :author "Miki Tebeka <miki.tebeka@gmail.com>"
      :doc "strftime for Clojure"}
  (:import java.util.Date
           java.util.Calendar))

(defmulti strftime 
  "Format time t according to format string fmt."
  (fn [fmt t] (class t)))

(defmethod strftime Date
  [fmt t]
  ; Convert strftime to String.format format (e.g. %m -> %1$tm)
  (let [fmt (.replaceAll fmt "%([a-zA-Z])" "%1\\$t$1")]
    (format fmt t)))

(defmethod strftime Long
  [fmt t]
  (strftime fmt (Date. t)))

(defmethod strftime Calendar
  [fmt t]
  (strftime fmt (.getTime t)))
