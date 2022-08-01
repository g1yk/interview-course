// https://leetcode.com/problems/search-in-a-binary-search-tree/
// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// https://leetcode.com/problems/delete-node-in-a-bst/

class BinarySearchTree {
    var root: TreeNode? = null

    fun get(`val`: Int) = get(root, `val`)

    private fun get(node: TreeNode?, `val`: Int): TreeNode? {
        if (node == null) return null
         
        return if (`val` < node.`val`)
                get(node.left, `val`)
            else if (`val` > node.`val`)
                get(node.right, `val`)
            else 
                node
    }

    fun put(`val`: Int) {
        this.root = put(root, `val`)
    }

    private fun put(node: TreeNode?, `val`: Int): TreeNode? {
        if (node == null) return TreeNode(`val`)

        if (`val` < node.`val`)
            node.left = put(node.left, `val`)
        else if (`val` > node.`val`)
            node.right = put(node.right, `val`)

        return node
    }

    fun delete(`val`: Int) {
        this.root = delete(root, `val`)
    }

    private fun delete(node: TreeNode?, `val`: Int): TreeNode? {
        if (node == null) return null
        
        if (`val` < node.`val`)
            node.left = delete(node.left, `val`)
        else if (`val` > node.`val`)
            node.right = delete(node.right, `val`)
        else {
            if (node.right == null)
                return node.left
            else if (node.left == null)
                return node.right
            else {
                var min = min(node.right)
                min.right = deleteMin(node.right)
                min.left = node.left
                return min
            }
        }
        return node
    }
    
    private fun min(node: TreeNode): TreeNode {
        return if (node.left == null) node else min(node.left)
    } 
    
    private fun deleteMin(node: TreeNode): TreeNode? {
        if (node.left == null) return node.right
        node.left = deleteMin(node.left)
        return node
    }
}
