(ns humdrum.parser
  (:require [instaparse.core :as insta]))


(def file-parser
  (insta/parser "resources/file.grammar"))


(file-parser
"!! bastard comment
**foo\t**bar
*thing\t*other
!bing\t!bang
pop\t.
*-\t*-")

(def wtc1f02 (slurp "resources/scores/wtc1f02.krn"))

(def parsed (file-parser wtc1f02))

