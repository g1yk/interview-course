import random
from typing import List


class MinHeap:
    def __init__(self, capacity: int):
        self.items = [None] * (capacity + 1)
        self.count = 0

    def size(self):
        return self.count

    def add(self, key: int):
        self.count += 1
        self.items[self.count] = key
        self.swim(self.count)

    def poll(self):
        result = self.items[1]
        self.swap(1, self.count)
        self.count -= 1
        self.sink(1)
        return result

    def swim(self, k: int):
        while k > 1 and self.greater(k // 2, k):
            self.swap(k // 2, k)
            k = k // 2

    def sink(self, k: int):
        while 2 * k <= self.count:
            j = 2 * k
            if j < self.count and self.greater(j, j + 1):
                j += 1
            if not self.greater(k, j):
                break
            self.swap(k, j)
            k = j

    def swap(self, i: int, j: int):
        self.items[i], self.items[j] = self.items[j], self.items[i]

    def greater(self, i: int, j: int):
        return self.items[i] > self.items[j]
