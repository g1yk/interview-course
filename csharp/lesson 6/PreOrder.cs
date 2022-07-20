// https://leetcode.com/problems/binary-tree-preorder-traversal/

class Solution 
{
    public IList<int> PreorderTraversal(TreeNode root)
    {
        var result = new List<int>();
        PreOrder(root, result);
        return result;
    }

    private void PreOrder(TreeNode node, List<int> result)
    {
        if (node == null) return;

        result.Add(node.val);
        PreOrder(node.left, result);        
        PreOrder(node.right, result);
    }
}
