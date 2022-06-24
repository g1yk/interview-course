class Node:
    def __init__(self, key, value, nxt):
        self.key = key
        self.value = value
        self.next = nxt

class SeparateChainingHashTable:
    INITIAL_CAPACITY = 4
    
    def __init__(self, capactiy = INITIAL_CAPACITY):
        self.count = 0
        self.capacity = capactiy
        self.buckets =  [None for _ in range(self.capacity)]

    def put(self, key, value):
        if self.count >= 10 * self.capacity: 
            self.resize(2 * self.capacity)
        i = self.__hash(key)
        node = self.buckets[i]
        while node:
            if key == node.key:
                node.value = value                
                return
            node = node.next
        self.buckets[i] = Node(key, value, self.buckets[i])
        self.count += 1

    def get(self, key):
        i = self.__hash(key)
        node = self.buckets[i]
        while node:
            if node.key == key: return node.value
            node = node.next
        return None

    def remove(self, key):
        i = self.__hash(key)
        node = self.buckets[i]
        prev = None
        while node:
            if key == node.key:
                if not prev:
                    self.buckets[i] = node.next
                else:
                    prev.next = node.next                
                self.count -= 1
                break            
            prev = node
            node = node.next
        if self.capacity > self.INITIAL_CAPACITY and self.count <= 2 * self.capacity:
            self.resize(self.capacity / 2) 

    def resize(self, size: int) -> None:
        temp = SeparateChainingHashTable(size)
        for i in range(self.capacity):
            node = self.buckets[i]
            while node:
                temp.put(node.key, node.value)
                node = node.next
        self.buckets = temp.buckets
        self.capacity = size

    def __hash(self, key):
        return key % self.capacity
