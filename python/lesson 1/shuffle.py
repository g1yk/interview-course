import random


class Solution:
    def shuffle(self, values):
        for i in range(len(values)):
            r = random.randrange(0, i + 1)
            values[i], values[r] = values[r], values[i]
