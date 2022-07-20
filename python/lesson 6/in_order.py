# https://leetcode.com/problems/binary-tree-inorder-traversal/

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.inorder(root, result)
        return result
    
    def inorder(self, node: Optional[TreeNode], result: List[int]):
        if node == None: 
            return        
        self.inorder(node.left, result)
        result.append(node.val)
        self.inorder(node.right, result)
