(ns katas.sorting
  "Sorting and binary search. Do not use `sort` or `sort-by` in the sorting exercises.")

(defn merge-sorted
  "Merge two vectors that are each sorted in ascending order into one sorted vector.

    (merge-sorted [1 3 5] [2 4 6]) ;=> [1 2 3 4 5 6]"
  [a b]
  (throw (ex-info "Not solved yet" {})))

(defn merge-sort
  "Sort a vector of numbers in ascending order with merge sort (split, sort each half, merge).

    (merge-sort [3 6 8 10 1 2 1]) ;=> [1 1 2 3 6 8 10]"
  [nums]
  (throw (ex-info "Not solved yet" {})))

(defn quick-sort
  "Sort a vector of numbers in ascending order with quicksort (choose a pivot, split into smaller and larger,
  sort each part).

    (quick-sort [3 6 8 10 1 2 1]) ;=> [1 1 2 3 6 8 10]"
  [nums]
  (throw (ex-info "Not solved yet" {})))

(defn search-rotated
  "`nums` was sorted in ascending order (no repeats) and then rotated at an unknown point, for example
  `[4 5 6 7 0 1 2]`. Return the index of `target`, or -1. Aim for O(log n).

    (search-rotated [4 5 6 7 0 1 2] 0) ;=> 4
    (search-rotated [4 5 6 7 0 1 2] 3) ;=> -1"
  [nums target]
  (throw (ex-info "Not solved yet" {})))

(defn first-last
  "`nums` is sorted in ascending order and may repeat values. Return `[first last]`, the first and the last index
  of `target`, or `[-1 -1]` when it is not there. Aim for O(log n).

    (first-last [5 7 7 8 8 8 10] 8) ;=> [3 5]
    (first-last [5 7 7 8 8 8 10] 6) ;=> [-1 -1]"
  [nums target]
  (throw (ex-info "Not solved yet" {})))
