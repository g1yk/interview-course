// https://leetcode.com/problems/binary-tree-postorder-traversal/

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        postOrder(root, result)
        return result
    }
    
    fun postOrder(node: TreeNode?, result: MutableList<Int>) {
        if (node == null) return

        postOrder(node.left, result)
        postOrder(node.right, result)
        result.add(node.`val`)
    }
}
