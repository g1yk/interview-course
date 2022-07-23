// https://leetcode.com/problems/binary-tree-inorder-traversal/

public class Solution
{
    public IList<int> InorderTraversal(TreeNode root)
    {
        var list = new List<int>();
        var stack = new Stack<TreeNode>();
        var current = root;
        while (current != null || stack.Count > 0)
        {
            if (current != null)
            {
                stack.Push(current);
                current = current.left;
            }
            else
            {
                current = stack.Pop();
                list.Add(current.val);
                current = current.right;
            }
        }
        return list;
    }
}
