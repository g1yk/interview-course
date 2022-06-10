from typing import Optional
from list_node import ListNode

# https://leetcode.com/problems/linked-list-cycle-ii/
class Solution:
    def detect_cycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None: return None
        
        intersect = self.get_intersect(head)
        if intersect == None: return None
        
        return self.get_cycle_start(head, intersect)        

    def get_intersect(self, head: ListNode) -> Optional[ListNode]:
        slow = fast = head
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
            if slow == fast: return slow
        return None

    def get_cycle_start(self, head: ListNode, intersect: ListNode) -> ListNode:
        one, two = head, intersect
        while one != two:
            one, two = one.next, two.next
        return one
