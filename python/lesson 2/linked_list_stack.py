from node import Node

class LinkedListStack:
    def __init__(self):
        self.head = None
  
    def push(self, value):
        self.head = Node(value, self.head)
  
    def pop(self):
        if self.head == None: raise Exception("Stack is empty")
        result = self.head.value
        self.head = self.head.next
        return result
