// https://leetcode.com/problems/middle-of-the-linked-list/

function middleNode(head) {
    let slow = head, fast = head;
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
