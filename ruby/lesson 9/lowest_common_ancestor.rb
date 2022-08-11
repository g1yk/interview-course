# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

def lowest_common_ancestor(root, p, q)
    return root if root.nil? || root == p || root == q

    left = lowest_common_ancestor(root.left, p, q)
    right = lowest_common_ancestor(root.right, p, q)

    return root if !left.nil? && !right.nil?
    left || right
end
