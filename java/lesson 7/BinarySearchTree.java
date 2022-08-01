// https://leetcode.com/problems/search-in-a-binary-search-tree/
// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// https://leetcode.com/problems/delete-node-in-a-bst/

public class BinarySearchTree {
    private TreeNode root;

    public TreeNode get(int val) {
        return get(root, val);
    }

    private TreeNode get(TreeNode node, int val) {
        if (node == null) return null;

        if (val < node.val)
            return get(node.left, val);
        else if (val > node.val)
            return get(node.right, val);
        else
            return node;
    }

    public void put(int val) {
        root = put(root, val);
    }

    private TreeNode put(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);

        if (val < node.val)
            node.left = put(node.left, val);
        else if (val > node.val)
            node.right = put(node.right, val);

        return node;
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    private TreeNode delete(TreeNode node, int val) {
        if (node == null) return null;

        if (val < node.val)
            node.left = delete(node.left, val);
        else if (val > node.val)
            node.right = delete(node.right, val);
        else {
            if (node.right == null)
                return node.left;
            else if (node.left == null)
                return node.right;
            else {
                TreeNode temp = node;
                node = min(temp.right);
                node.right = deleteMin(temp.right);
                node.left = temp.left;
            }
        }
        return node;
    }

    private TreeNode min(TreeNode node) {
        return node.left == null ? node : min(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) return node.right;
        
        node.left = deleteMin(node.left);
        return node;
    }
}
