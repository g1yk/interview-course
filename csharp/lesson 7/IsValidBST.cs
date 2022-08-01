// https://leetcode.com/problems/validate-binary-search-tree/

public class Solution
{
    public bool IsValidBST(TreeNode root)
    {
        return IsValid(root);
    }
    
    private bool IsValid(TreeNode node, int? min = null, int? max = null)
    {
        if (node == null) return true;
        
        if (node.val <= min || node.val >= max) return false;
        
        return IsValid(node.left, min, node.val) && IsValid(node.right, node.val, max);
    }
}
