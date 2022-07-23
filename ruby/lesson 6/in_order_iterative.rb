# https://leetcode.com/problems/binary-tree-inorder-traversal/

def inorder_traversal(root)
    list = []
    stack = []
    current = root
    while !current.nil? || !stack.empty? do
        if !current.nil?
            stack.push(current)
            current = current.left
        else
            current = stack.pop()
            list.push(current.val)
            current = current.right
        end
    end
    list
end
