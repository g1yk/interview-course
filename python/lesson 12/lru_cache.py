# https://leetcode.com/problems/lru-cache/

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = dict()
        self.list = DoubleLinkedList() 
        

    def get(self, key: int) -> int:
        if key in self.map:        
            node = self.map[key]
            self.list.moveToHead(node)
            return node.val
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            node = self.map[key]
            node.val = value
            self.list.moveToHead(node)
        else:
            node = Node(key, value)
            self.map[key] = node
            self.list.addToHead(node)
            
            if len(self.map) > self.capacity:
                r = self.list.removeFromTail()
                del self.map[r.key]
        

class Node:
    def __init__(self, key: int, value: int):
        self.key = key
        self.val = value
        self.prev = None
        self.next = None
        

class DoubleLinkedList:
    def __init__(self):
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.prev = self.tail
        self.tail.next = self.head
        
    def addToHead(self, node: Node):
        prev = self.head.prev
        prev.next = node
        node.prev = prev
        node.next = self.head
        self.head.prev = node
        return node

    def moveToHead(self, node: Node):
        prev = node.prev
        _next = node.next            
        prev.next = _next
        _next.prev = prev
        self.addToHead(node)

    def removeFromTail(self) -> Node:
        result = self.tail.next
        self.tail.next = result.next
        result.next.prev = self.tail
        result.prev = None
        result.next = None
        return result
