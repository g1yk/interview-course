# https://leetcode.com/problems/binary-tree-level-order-traversal/

def level_order(root)
    result = []
    return result if root.nil?

    queue = Queue.new
    queue.push(root)

    while !queue.empty?
        size = queue.length
        level = []
        for i in 0..size-1
            node = queue.deq
            level.push(node.val)
            queue.push(node.left) unless node.left.nil?
            queue.push(node.right) unless node.right.nil?
        end
        result.push(level)
    end
    result
end
