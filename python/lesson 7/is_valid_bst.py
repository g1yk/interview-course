# https://leetcode.com/problems/validate-binary-search-tree/

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.isValid(root)
        
    def isValid(self, node: Optional[TreeNode], min: Optional[int]=None, max: Optional[int]=None) -> bool:
        if node == None: return True
        if min != None and node.val <= min or max != None and node.val >= max: return False
        return self.isValid(node.left, min, node.val) and self.isValid(node.right, node.val, max)