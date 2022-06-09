from typing import Optional
from list_node import ListNode

# https://leetcode.com/problems/linked-list-cycle-ii/
class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None: return None
        
        intersect = self.getIntersect(head)
        if intersect == None: return None
        
        return self.getCycleStart(head, intersect)        

    def getIntersect(self, head: ListNode) -> Optional[ListNode]:
        slow = fast = head
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
            if slow == fast: return slow
        return None

    def getCycleStart(self, head: ListNode, intersect: ListNode) -> ListNode:
        one, two = head, intersect
        while one != two:
            one, two = one.next, two.next
        return one
