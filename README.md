# clj-katas

Classic algorithm exercises to solve in **Clojure**. Every function is declared and documented, and **left unsolved**: the tests are red until you write the solution.

The same problems, solved in C#, are in [`csharp-katas`](https://github.com/hannmtz-85/csharp-katas). The statements here are written from scratch, in the docstring of each function.

## How it works

1. Pick an exercise from the table and open its file in `src/katas`.
2. Read the docstring, which is the statement, with its examples and its constraints.
3. Replace the `(throw (ex-info "Not solved yet" {}))` with your solution.
4. Run the tests:

```
clojure -M:test                                            ; everything
clojure -M:test --focus katas.arrays-test/two-sum-sorted   ; one exercise
```

You need the [Clojure CLI](https://clojure.org/guides/install_clojure) and a JDK 21 or later. At the start, every test is an error; that is the starting line.

**To practise for a coding session:** set a timer for the suggested time, say your reasoning aloud, and evaluate in the REPL as you go. When it passes, read the docstring again and ask yourself what the complexity is and which case you did not test.

## Exercises

Time is a suggestion for a timed session; difficulty is relative to the other exercises here.

| Technique | Exercise (function) | Difficulty | Time |
|---|---|---|---|
| Fast and slow pointers | [`duplicate-number`](src/katas/pointers.clj) | Medium | 20 min |
| | [`happy?`](src/katas/pointers.clj) | Easy | 15 min |
| Two pointers | [`move-zeroes`](src/katas/pointers.clj) | Easy | 10 min |
| | [`two-sum-sorted`](src/katas/pointers.clj) | Easy | 10 min |
| | [`valid-palindrome-2?`](src/katas/pointers.clj) | Easy | 15 min |
| Sliding window | [`candy-collector`](src/katas/window.clj) | Medium | 20 min |
| | [`longest-unique-substring`](src/katas/window.clj) | Medium | 20 min |
| | [`max-consecutive-ones`](src/katas/window.clj) | Medium | 20 min |
| | [`min-window`](src/katas/window.clj) | Hard | 40 min |
| Stacks | [`simplify-path`](src/katas/stacks.clj) | Medium | 25 min |
| | [`balanced?`](src/katas/stacks.clj) | Easy | 15 min |
| Greedy | [`candy-distribution`](src/katas/greedy.clj) | Hard | 30 min |
| | [`can-reach-end?`](src/katas/greedy.clj) | Medium | 20 min |
| Linked lists | [`add-numbers`](src/katas/lists.clj) | Medium | 30 min |
| | [`reverse-list`](src/katas/lists.clj) | Easy | 10 min |
| Graphs | [`task-order`](src/katas/graphs.clj) | Medium | 30 min |
| | [`can-finish?`](src/katas/graphs.clj) | Medium | 25 min |
| | [`bfs-order`](src/katas/graphs.clj) | Medium | 20 min |
| | [`apply-modifiers`](src/katas/graphs.clj) | Medium | 30 min |
| Sorting and searching | [`merge-sorted`](src/katas/sorting.clj), [`merge-sort`](src/katas/sorting.clj) | Medium | 25 min |
| | [`quick-sort`](src/katas/sorting.clj) | Medium | 20 min |
| | [`search-rotated`](src/katas/sorting.clj) | Hard | 30 min |
| | [`first-last`](src/katas/sorting.clj) | Medium | 25 min |
| Trees | [`inorder`, `preorder`, `postorder`](src/katas/trees.clj) | Easy | 15 min |
| | [`bst-search`](src/katas/trees.clj), [`valid-bst?`](src/katas/trees.clj) | Medium | 25 min |
| | [`lowest-common-ancestor`](src/katas/trees.clj) | Medium | 20 min |
| Hash maps | [`two-sum`](src/katas/hashing.clj) | Easy | 10 min |
| | [`group-anagrams`](src/katas/hashing.clj) | Easy | 15 min |
| Recursion and DP | [`power-of-two?`](src/katas/recursion.clj) | Easy | 10 min |
| | [`fibonacci`](src/katas/recursion.clj), [`climb-stairs`](src/katas/recursion.clj) | Easy | 20 min |
| Design | [`lru-new`, `lru-get`, `lru-put`](src/katas/design.clj) | Hard | 40 min |
| | [`limiter-new`, `allow?`](src/katas/design.clj) | Medium | 25 min |

## Data conventions

Clojure values are immutable, so the exercises use plain data:

- A list node is `{:val 1 :next <node or nil>}`; a tree node is `{:val 8 :left .. :right ..}`; nil is the empty list or tree.
- A graph is a map from a node to the set of its children.
- A structure with state (the cache, the rate limiter) is a value that each function takes and returns.

## License

[MIT](LICENSE)
