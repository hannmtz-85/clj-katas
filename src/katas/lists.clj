(ns katas.lists
  "Linked lists. A list node is `{:val 1 :next <node or nil>}`.")

(defn add-numbers
  "Two non-negative integers are written as vectors of digits, most significant digit first. Return their sum in
  the same form. Do not convert the vectors to numbers: add digit by digit with a carry.

    (add-numbers [3 5 1] [1 2 1]) ;=> [4 7 2]
    (add-numbers [9 9] [1])       ;=> [1 0 0]"
  [a b]
  (throw (ex-info "Not solved yet" {})))

(defn reverse-list
  "Return the singly linked list that starts at `head` (nil for an empty list) with its nodes in the opposite
  order.

    (reverse-list {:val 1 :next {:val 2 :next nil}}) ;=> {:val 2 :next {:val 1 :next nil}}"
  [head]
  (throw (ex-info "Not solved yet" {})))
