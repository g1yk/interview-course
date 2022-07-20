// https://leetcode.com/problems/binary-tree-inorder-traversal/

class Solution 
{
    public IList<int> InorderTraversal(TreeNode root)
    {
        var result = new List<int>();
        InOrder(root, result);
        return result;
    }

    private void InOrder(TreeNode node, List<int> result)
    {
        if (node == null) return;

        InOrder(node.left, result);
        result.Add(node.val);
        InOrder(node.right, result);
    }
}
