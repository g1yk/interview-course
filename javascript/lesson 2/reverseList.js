// https://leetcode.com/problems/reverse-linked-list

function reverseList(head) {
    let prev = null, next = null, current = head;
    while (current) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}
