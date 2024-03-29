// https://leetcode.com/problems/middle-of-the-linked-list/

public class Solution 
{
    public ListNode MiddleNode(ListNode head)
    {
        ListNode slow = head, fast = head;
        while (fast?.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
