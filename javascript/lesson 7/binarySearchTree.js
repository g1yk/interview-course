// https://leetcode.com/problems/search-in-a-binary-search-tree/
// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// https://leetcode.com/problems/delete-node-in-a-bst/

class BinarySearchTree {
    constructor() {
        this.root = null;
    }
    
    get(val) {
        this.get(this.root, val);
    }
    
    get(node, val) {
        if (!node) return null;
        
        if (val < node.val) return this.get(node.left, val);
        if (val > node.val) return this.get(node.right, val);
        return node;
    }
    
    put(val) {
        this.root = this.put(this.root, val);
    }
    
    put(node, val) {
        if (!node) return new TreeNode(val);

        if (val < node.val)
            node.left = this.put(node.left, val);
        else if (val > node.val)
            node.right = this.put(node.right, val);
        else
            node.val = val;

        return node;
    }   
    
    delete(val) {
        this.root = this.delete(this.root, val);
    }
    
    delete(node, val) {
        if (!node) return null;
        
        if (val < node.val) node.left = this.delete(node.left, val);
        else if (val > node.val) node.right = this.delete(node.right, val);
        else {
            if (node.right == null) return node.left;
            else if (node.left == null) return node.right;
            else {
                const temp = node;
                node = this.min(temp.right);
                node.right = this.deleteMin(temp.right);
                node.left = temp.left;
            }
        }
        return node;
    }
    
    min(node) {
        return !node.left ? node : this.min(node.left); 
    }
    
    deleteMin(node) {
        if (!node.left) return node.right;
        node.left = this.deleteMin(node.left);
        return node;
    }
}
