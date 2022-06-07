public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode intersect = getIntersect(head);
        if (intersect == null) return null;

        return getCycleStart(head, intersect);
    }

    private ListNode getIntersect(ListNode head) {
        ListNode slow = head, fast = head;        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }
    
    private ListNode getCycleStart(ListNode head, ListNode intersect) {
        ListNode one = head, two = intersect;        
        while (one != two) {
            one = one.next;
            two = two.next;
        }
        return one;
    }
}
