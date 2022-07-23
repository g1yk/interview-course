// https://leetcode.com/problems/binary-tree-level-order-traversal/

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return result

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (!queue.isEmpty()) {
            val size = queue.size
            val level = mutableListOf<Int>()
            for (i in 0 .. size - 1) {
                val node = queue.poll()
                level.add(node.`val`)
                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
            }
            result.add(level)
        }

        return result
    }
}
