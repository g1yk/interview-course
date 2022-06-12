from typing import Any

class ArrayStack:
    def __init__(self):
        self.stack = []
        
    def push(self, val) -> None:
        self.stack.append(val)

    def pop(self) -> Any:
        return self.stack.pop()
