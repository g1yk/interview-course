# https://leetcode.com/problems/binary-tree-postorder-traversal/

def postorder_traversal(root)
    result = []
    postorder(root, result)
    result
end

def postorder(node, result)
    return if node.nil?

    postorder(node.left, result)
    postorder(node.right, result)
    result.push(node.val)
end
