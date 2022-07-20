// https://leetcode.com/problems/binary-tree-inorder-traversal/

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        inOrder(root, result)
        return result
    }
    
    fun inOrder(node: TreeNode?, result: MutableList<Int>) {
        if (node == null) return

        inOrder(node.left, result)
        result.add(node.`val`)
        inOrder(node.right, result)
    }
}
