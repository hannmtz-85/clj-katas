(ns katas.trees
  "Binary trees. A node is `{:val 8 :left <node or nil> :right <node or nil>}`; nil is the empty tree.")

(defn inorder
  "Values in order: left subtree, the node, right subtree."
  [tree]
  (throw (ex-info "Not solved yet" {})))

(defn preorder
  "Values in pre-order: the node, left subtree, right subtree."
  [tree]
  (throw (ex-info "Not solved yet" {})))

(defn postorder
  "Values in post-order: left subtree, right subtree, the node."
  [tree]
  (throw (ex-info "Not solved yet" {})))

(defn bst-search
  "`tree` is a binary search tree (smaller values on the left, larger on the right). Return the node whose value is
  `target`, or nil."
  [tree target]
  (throw (ex-info "Not solved yet" {})))

(defn valid-bst?
  "Say whether `tree` is a valid binary search tree: for every node, all the values in its left subtree are
  smaller and all those in its right subtree are larger (no repeated values). A node may be wrong far from its
  parent, so comparing with the parent only is not enough. nil is valid.

  Aim for O(n) time."
  [tree]
  (throw (ex-info "Not solved yet" {})))

(defn lowest-common-ancestor
  "`tree` is a valid binary search tree holding the values `p` and `q`. Return the value of their lowest common
  ancestor: the deepest node that has both in its subtree (a node counts as its own ancestor)."
  [tree p q]
  (throw (ex-info "Not solved yet" {})))
