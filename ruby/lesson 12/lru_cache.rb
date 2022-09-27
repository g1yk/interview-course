# https://leetcode.com/problems/lru-cache/
    
class LRUCache
    def initialize(capacity)
        @capacity = capacity
        @map = {}
        @list = DoubleLinkedList.new 
    end

    def get(key)
        return -1 unless @map.include?(key)

        node = @map[key]
        @list.move_to_head(node)
        node.val
    end

    def put(key, value)
        if @map.include?(key)
            node = @map[key]
            node.val = value
            @list.move_to_head(node)
        else
            node = Node.new(key, value)
            @map[key] = node
            @list.add_to_head(node)
            
            @map.delete(@list.remove_from_tail.key) if @map.size > @capacity
        end
    end
end

class Node
    attr_accessor :key, :val, :prev, :next

    def initialize(key, value)
        @key = key
        @val = value
        @prev = nil
        @next = nil
    end
end

class DoubleLinkedList
    def initialize()
        @head = Node.new(0, 0)
        @tail = Node.new(0, 0)
        @head.prev = @tail
        @tail.next = @head
    end
    
    def add_to_head(node)
        prev = @head.prev
        prev.next = node
        node.prev = prev
        node.next = @head
        @head.prev = node
        node
    end

    def move_to_head(node)
        prev = node.prev
        _next = node.next
        prev.next = _next
        _next.prev = prev
        add_to_head(node)
    end

    def remove_from_tail()
        result = @tail.next
        @tail.next = result.next
        result.next.prev = @tail
        result.prev = nil
        result.next = nil
        result
    end
end
