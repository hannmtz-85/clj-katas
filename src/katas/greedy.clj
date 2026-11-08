(ns katas.greedy
  "Greedy algorithms.")

(defn candy-distribution
  "Children sit in a row and have the ratings in `ratings`. Each child gets at least one candy, and a child with a
  higher rating than a neighbour gets more candies than that neighbour (equal ratings may get equal candies). Use
  as few candies as possible. Return `{:candies [..] :total n}`: the candies of each child, and their sum.

    (candy-distribution [1 5 3 2]) ;=> {:candies [1 3 2 1] :total 7}
    (candy-distribution [4 4 4])   ;=> {:candies [1 1 1] :total 3}"
  [ratings]
  (throw (ex-info "Not solved yet" {})))

(defn can-reach-end?
  "You stand on the first index of `jumps`. From index i you may jump forward any distance from 1 to `(jumps i)`.
  Say whether you can reach the last index.

    (can-reach-end? [2 3 1 1 4]) ;=> true
    (can-reach-end? [3 2 1 0 4]) ;=> false"
  [jumps]
  (throw (ex-info "Not solved yet" {})))
