# https://leetcode.com/problems/binary-tree-preorder-traversal/

class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.preorder(root, result)
        return result
    
    def preorder(self, node: Optional[TreeNode], result: List[int]):
        if node == None: 
            return
        result.append(node.val)
        self.preorder(node.left, result)
        self.preorder(node.right, result)