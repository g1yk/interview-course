# https://leetcode.com/problems/validate-binary-search-tree/

def is_valid_bst(root)
    is_valid(root)
end

def is_valid(node, min = nil, max = nil)
    return true if node.nil?
    return false if !min.nil? && node.val <= min || !max.nil? && node.val >= max
    return is_valid(node.left, min, node.val) && is_valid(node.right, node.val, max)
end