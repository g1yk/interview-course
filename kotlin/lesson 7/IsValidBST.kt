// https://leetcode.com/problems/validate-binary-search-tree/

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValid(root)
    }
    
    private fun isValid(node: TreeNode?, min: Int? = null, max: Int? = null): Boolean {
        if (node == null) return true

        if (min != null && node.`val` <= min || max != null && node.`val` >= max) {
            return false
        }
        
        return isValid(node.left, min, node.`val`) && isValid(node.right, node.`val`, max)
    }
}
