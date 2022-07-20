# https://leetcode.com/problems/binary-tree-postorder-traversal/

class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.postorder(root, result)
        return result
    
    def postorder(self, node: Optional[TreeNode], result: List[int]):
        if node == None: 
            return
        self.postorder(node.left, result)
        self.postorder(node.right, result)
        result.append(node.val)

