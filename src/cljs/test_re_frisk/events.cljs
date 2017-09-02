(ns test-re-frisk.events
  (:require [re-frame.core :as re-frame]
            [test-re-frisk.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-fx
  :clock?-db
  (fn
    ;; the first item in the second argument is :timer the second is the
    ;; new value
    [{db :db} [_ value]]
    {:db (assoc db :clock? value)}))

(re-frame/reg-event-db
  :timer-db
  (fn
    ;; the first item in the second argument is :timer the second is the
    ;; new value
    [db [_ value]]
    (assoc db :timer value)))    ;; return the new version of db