import collections
from heapq import heappop, heappush
from typing import List

# https://leetcode.com/problems/kth-largest-element-in-an-array


class Node:
    def __init__(self, word, freq):
        self.word = word
        self.freq = freq

    def __lt__(self, other):
        if self.freq == other.freq:
            return self.word > other.word
        return self.freq < other.freq


class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        freq = collections.Counter(words)
        heap = list()
        for word, count in freq.items():
            node = Node(word, count)
            heappush(heap, node)
            if len(heap) > k:
                heappop(heap)

        result = list()
        while heap:
            result.append(heappop(heap).word)

        return result[::-1]
