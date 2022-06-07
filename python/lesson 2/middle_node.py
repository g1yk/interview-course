from typing import Optional
from list_node import ListNode

class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow: Optional[ListNode] = head
        fast: Optional[ListNode] = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
