# https://leetcode.com/problems/design-hashmap/

class LinearProbingHashTable:
    INITIAL_CAPACITY = 4

    def __init__(self, capactiy=INITIAL_CAPACITY):
        self.count = 0
        self.capacity = capactiy
        self.keys = [None] * self.capacity
        self.values = [None] * self.capacity

    def put(self, key, value):
        if self.count >= self.capacity / 2:
            self.__resize(2 * self.capacity)
        i = self.__hash(key)
        while self.keys[i] is not None:
            if key == self.keys[i]:
                break
            i = (i + 1) % self.capacity
        self.keys[i] = key
        self.values[i] = value
        self.count += 1

    def get(self, key):
        i = self.__hash(key)
        while self.keys[i] is not None:
            if key == self.keys[i]:
                return self.values[i]
            i = (i + 1) % self.capacity
        return None

    def remove(self, key):
        i = self.__hash(key)
        while self.keys[i] is not None:
            if key != self.keys[i]:
                i = (i + 1) % self.capacity
                continue
            self.keys[i] = None
            self.values[i] = None
            # rehash all keys in same cluster
            i = (i + 1) % self.capacity
            while self.keys[i] is not None:
                key_to_rehash = self.keys[i]
                val_to_rehash = self.values[i]
                self.keys[i] = None
                self.values[i] = None
                self.count -= 1
                self.put(key_to_rehash, val_to_rehash)
                i = (i + 1) % self.capacity
            self.count -= 1
        if self.count > 0 and self.count < self.capacity / 8:
            self.__resize(self.capacity // 2)

    def __resize(self, size: int) -> None:
        temp = LinearProbingHashTable(size)
        for i in range(self.capacity):
            if self.keys[i] is None:
                continue
            temp.put(self.keys[i], self.values[i])
        self.keys = temp.keys
        self.values = temp.values
        self.capacity = size

    def __hash(self, key):
        return key % self.capacity
