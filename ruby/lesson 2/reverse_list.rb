# https://leetcode.com/problems/reverse-linked-list

def reverse_list(head)
    prev = _next = nil
    current = head
    while current
        _next = current.next
        current.next = prev
        prev = current
        current = _next
    end
    prev
end
