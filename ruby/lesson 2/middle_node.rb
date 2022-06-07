def middle_node(head)
    slow = fast = head
    while fast&.next
        slow = slow.next
        fast = fast.next.next
    end
    slow
end
