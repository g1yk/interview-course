# https://leetcode.com/problems/binary-tree-level-order-traversal/

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root == None: return result
        
        queue = deque()
        queue.append(root)
        
        while len(queue) > 0:
            size = len(queue)
            level = []
            for i in range(size):
                node = queue.popleft()
                level.append(node.val)
                if node.left != None:
                    queue.append(node.left)
                if node.right != None: 
                    queue.append(node.right)
            result.append(level)
        return result
