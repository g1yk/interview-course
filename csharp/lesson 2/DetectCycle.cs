// https://leetcode.com/problems/linked-list-cycle-ii/

public class Solution {
    public ListNode DetectCycle(ListNode head)
    {
        if (head == null) return null;
        
        var intersect = GetIntersect(head);
        if (intersect == null) return null;

        return GetCycleStart(head, intersect);
    }

    private ListNode GetIntersect(ListNode head)
    {
        ListNode slow = head, fast = head;        
        while (fast?.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }

    private ListNode GetCycleStart(ListNode head, ListNode intersect)
    {
        ListNode one = head, two = intersect;        
        while (one != two)
        {
            one = one.next;
            two = two.next;
        }
        return one;
    }
}
