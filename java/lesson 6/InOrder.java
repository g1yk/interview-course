// https://leetcode.com/problems/binary-tree-inorder-traversal/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }
}
