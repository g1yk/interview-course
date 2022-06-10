from typing import Optional
from list_node import ListNode

# https://leetcode.com/problems/middle-of-the-linked-list/
class Solution:
    def middle_node(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
