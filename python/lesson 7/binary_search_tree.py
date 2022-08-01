# https://leetcode.com/problems/search-in-a-binary-search-tree/
# https://leetcode.com/problems/insert-into-a-binary-search-tree/
# https://leetcode.com/problems/delete-node-in-a-bst/

class BinarySearchTree:
    def __init__(self):
        self.root = None
        
    def get(self, val: int):
        self.get_value(self, self.root, val)
        
    def get_value(self, node: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if node == None: return None
        
        if val < node.val:
            return self.get_value(node.left, val)
        elif val > node.val:
            return self.get_value(node.right, val)
        else:
            return node 
        
    def put(self, val: int):
        self.root = self.put_value(self, self.root, val)
    
    def put_value(self, node: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if node == None: return TreeNode(val)
        
        if val < node.val:
            node.left = self.put_value(node.left, val)
        elif val > node.val:
            node.right = self.put_value(node.right, val)
        
        return node 
    
    def delete(self, val: int):
        self.root = self.delete_value(self.root, val)
    
    def delete_value(self, node: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if node == None: return None
        
        if val < node.val:
            node.left = self.delete_value(node.left, val)
        elif val > node.val:
            node.right = self.delete_value(node.right, val)
        else:
            if node.right == None:
                return node.left
            if node.left == None:
                return node.right
            temp = node
            node = self.min(temp.right)
            node.right = self.delete_min(temp.right)
            node.left = temp.left
        return node
    
    def min(self, node: Optional[TreeNode]) -> Optional[TreeNode]:
        if node.left == None:
            return node
        return self.min(node.left)
    
    def delete_min(self, node: Optional[TreeNode]) -> Optional[TreeNode]:
        if node.left == None:
            return node.right
        node.left = self.delete_min(node.left)
        return node
