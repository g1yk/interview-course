# https://leetcode.com/problems/binary-tree-inorder-traversal/

def inorder_traversal(root)
    result = []
    inorder(root, result)
    result
end

def inorder(node, result)
    return if node.nil?

    inorder(node.left, result)
    result.push(node.val)
    inorder(node.right, result)
end
