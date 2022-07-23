// https://leetcode.com/problems/binary-tree-inorder-traversal/

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var current = root
        while (current != null || !stack.empty()) {
            if (current != null) {
                stack.push(current)
                current = current.left
            } else {
                current = stack.pop()
                list.add(current.`val`)
                current = current.right
            }
        }
        return list
    }
}
