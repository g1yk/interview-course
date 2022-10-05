# https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder:

    def __init__(self):
        self.maxHeap = []
        self.minHeap = []

    def addNum(self, num):
        if len(self.maxHeap) == len(self.minHeap):
            heappush(self.minHeap, -heappushpop(self.maxHeap, -num))
        else:
            heappush(self.maxHeap, -heappushpop(self.minHeap, num))

    def findMedian(self):
        if len(self.maxHeap) == len(self.minHeap):
            return float(self.minHeap[0] - self.maxHeap[0]) / 2.0
        else:
            return float(self.minHeap[0])
