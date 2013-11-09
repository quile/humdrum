;;;-----------------------------------------------------
;;; humdrum parser
;;; This should be able to parse any arbitrary humdrum
;;; file into a parse tree that can be rapidly traversed
;;; by the toolkit.
;;;-----------------------------------------------------
(ns humdrum.parser
  (:require [instaparse.core :as insta]
            [clojure.zip :as zip] :reload
            [clojure.string :as string]
            [clojure.java.io :as io]))

(defn tokenise [reader]
  (let [lines (line-seq reader)]
    (map #(string/split % #"\t") lines)))

(def file-parser
  (insta/parser "resources/file.grammar"))

(defn remove-comments
  "Removes global comments from raw parsed output"
  ([tree] (remove-comments tree {}))
  ([tree opts]
    (remove #(-> % second first (= :global-comment-line)) tree)))

;; just some test fun for now
(def wtc1f02 (io/reader "resources/scores/wtc1f02.krn"))
(def parsed (tokenise wtc1f02))

(doall parsed)
(remove-comments parsed)
