// https://leetcode.com/problems/binary-tree-preorder-traversal/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }
}