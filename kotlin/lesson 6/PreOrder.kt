// https://leetcode.com/problems/binary-tree-preorder-traversal/

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        preOrder(root, result)
        return result
    }
    
    fun preOrder(node: TreeNode?, result: MutableList<Int>) {
        if (node == null) return

        result.add(node.`val`)
        preOrder(node.left, result)
        preOrder(node.right, result)
    }
}
