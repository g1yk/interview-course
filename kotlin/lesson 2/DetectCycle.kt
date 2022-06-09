// https://leetcode.com/problems/linked-list-cycle-ii/

class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) return null

        val intersect = getIntersect(head)
        if (intersect == null) return null

        return getCycleStart(head, intersect)
    }

    private fun getIntersect(head: ListNode?): ListNode? {
        var slow = head; var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next.next
            if (slow == fast) return slow
        }
        return null
    }

    private fun getCycleStart(head: ListNode, intersect: ListNode): ListNode? {
        var one = head; var two = intersect;
        while (one != two) {
            one = one.next
            two = two.next
        }
        return one
    }
}
