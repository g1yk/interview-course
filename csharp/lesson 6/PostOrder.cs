// https://leetcode.com/problems/binary-tree-postorder-traversal/

class Solution 
{
    public IList<int> PostorderTraversal(TreeNode root)
    {
        var result = new List<int>();
        PostOrder(root, result);
        return result;
    }

    private void PostOrder(TreeNode node, List<int> result)
    {
        if (node == null) return;

        PostOrder(node.left, result);        
        PostOrder(node.right, result);
        result.Add(node.val);
    }
}
