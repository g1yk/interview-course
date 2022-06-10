// https://leetcode.com/problems/reverse-linked-list

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null, current = head;        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
