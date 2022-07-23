# https://leetcode.com/problems/binary-tree-inorder-traversal/

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        list, stack, current = [], [], root
        while current or len(stack) > 0:
            if current:
                stack.append(current)
                current = current.left
            else:
                current = stack.pop()
                list.append(current.val)
                current = current.right
        return list
