from typing import Optional
from list_node import ListNode

# https://leetcode.com/problems/reverse-linked-list
class Solution:
    def reverse_list(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = next = None
        current = head
        while current:
            next = current.next
            current.next = prev
            prev = current
            current = next
        return prev
