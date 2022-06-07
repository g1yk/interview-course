function detectCycle(head) {
    const intersect = head && getIntersect(head);
    return intersect && getCycleStart(head, intersect);
}

function getIntersect(head) {
    let slow = head, fast = head;
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow === fast) return slow;
    }
    return null;
}

function getCycleStart(head, intersect) {
    let one = head, two = intersect;        
    while (one !== two) {
        one = one.next;
        two = two.next;
    }
    return one;
}
