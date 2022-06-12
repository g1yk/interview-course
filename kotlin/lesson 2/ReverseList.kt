class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var next: ListNode? = null
        var current = head
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        return prev
    }
}
