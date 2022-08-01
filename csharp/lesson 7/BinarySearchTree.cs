// https://leetcode.com/problems/search-in-a-binary-search-tree/
// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// https://leetcode.com/problems/delete-node-in-a-bst/

public class BinarySearchTree
{
    private TreeNode root;

    public TreeNode Get(int val)
    {
        return Get(root, val);
    }

    private TreeNode Get(TreeNode node, int val)
    {
        if (node == null) return null;
        if (val < node.val)
            return Get(node.left, val);
        else if (val > node.val)
            return Get(node.right, val);
        else
            return node;
    }

    public void Put(int val)
    {
        root = Put(root, val);
    }

    private TreeNode Put(TreeNode node, int val)
    {
        if (node == null) return new TreeNode(val);
        
        if (val < node.val)
            node.left = Put(node.left, val);
        else if (val > node.val)
            node.right = Put(node.right, val);

        return node;
    }

    public void Delete(int val)
	{
		root = Delete(root, val);
	}

    private TreeNode Delete(TreeNode node, int val)
    {
        if (node == null) return null;

        if (val < node.val)
            node.left = Delete(node.left, val);
        else if (val > node.val)
            node.right = Delete(node.right, val);
        else
        {
            if (node.right == null)
                return node.left;
            else if (node.left == null)
                return node.right;
            else
            {
                var temp = node;
                node = Min(temp.right);
                node.right = DeleteMin(temp.right);
                node.left = temp.left;
            }
        }
        return node;
    }

    private TreeNode Min(TreeNode node)
    {
        return node.left == null ? node : Min(node.left);
    }

    private TreeNode DeleteMin(TreeNode node)
    {
        if (node.left == null) return node.right;
        node.left = DeleteMin(node.left);
        return node;
    }
}
