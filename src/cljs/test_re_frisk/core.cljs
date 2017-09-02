(ns test-re-frisk.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [test-re-frisk.events]
            [test-re-frisk.subs]
            [test-re-frisk.views :as views]
            [test-re-frisk.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defonce time-updater (js/setInterval
                        #(re-frame/dispatch [:timer-db (js/Date.) "test"]) 1000))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
