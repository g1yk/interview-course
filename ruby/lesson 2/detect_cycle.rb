def detect_cycle(head)
    return nil if head == nil
    intersect = get_intersect(head)
    intersect && get_cycle_start(head, intersect)
end

def get_intersect(head)
    slow = fast = head
    while fast&.next
        slow = slow.next
        fast = fast.next.next
        return slow if slow == fast
    end
    nil
end

def get_cycle_start(head, intersect)
    one = head
    two = intersect
    while one != two
        one = one.next
        two = two.next
    end
    one
end
