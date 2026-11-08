(ns katas.graphs
  "Graphs. A graph is a map from a node to the set of its children: `{1 #{2 3}, 2 #{}, 3 #{}}`.")

(defn task-order
  "Tasks are numbers. For every i, task `(primary i)` must be done before task `(dependent i)`. Return a vector
  with an order in which tasks can be done so that every note is respected. Only tasks that appear in the notes
  count. If some tasks depend on each other in a cycle, they cannot be done and are left out.

    (task-order [1 2 1] [2 3 4]) ;=> [1 2 3 4]   (or [1 2 4 3]: any valid order)"
  [primary dependent]
  (throw (ex-info "Not solved yet" {})))

(defn can-finish?
  "There are `n` courses numbered 0 to n - 1. For every i, course `(primary i)` is a prerequisite of course
  `(dependent i)`. Say whether all the courses can be finished: whether the prerequisites contain no cycle.

    (can-finish? [0] [1] 2)     ;=> true
    (can-finish? [0 1] [1 0] 2) ;=> false"
  [primary dependent n]
  (throw (ex-info "Not solved yet" {})))

(defn bfs-order
  "Return the nodes of `graph` in breadth-first (level) order, starting at the root: the one node that is nobody's
  child. Children of a node are visited in ascending order. An empty graph gives an empty vector.

    (bfs-order {1 #{2 3}, 2 #{4}, 3 #{}, 4 #{}}) ;=> [1 2 3 4]"
  [graph]
  (throw (ex-info "Not solved yet" {})))

(defn apply-modifiers
  "Apply the `modifiers` to `graph`, in the order of the vector, and return the level order of the result (as in
  `bfs-order`). A modifier is `[node op subject]` with `op` either `:add` or `:remove`:

  - `:add` makes `subject` a child of `node` (and a node of the graph if it was not one); if it already was a
    child, nothing changes;
  - `:remove` removes `subject` from the children of `node`; if it was not one, nothing changes;
  - a modifier whose `node` is not in the graph is ignored.

    (apply-modifiers {1 #{2 3}, 2 #{}, 3 #{}} [[3 :add 4]]) ;=> [1 2 3 4]"
  [graph modifiers]
  (throw (ex-info "Not solved yet" {})))
