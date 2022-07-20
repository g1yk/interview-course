# https://leetcode.com/problems/binary-tree-preorder-traversal/

def preorder_traversal(root)
    result = []
    preorder(root, result)
    result
end

def preorder(node, result)
    return if node.nil?

    result.push(node.val)
    preorder(node.left, result)
    preorder(node.right, result)
end