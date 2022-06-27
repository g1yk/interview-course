import random
from typing import List

# https://leetcode.com/problems/kth-largest-element-in-an-array
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        self.shuffle(nums)
        find = len(nums) - k
        lo = 0
        hi = len(nums) - 1
        while lo < hi:
            pivot = self.partition(nums, lo, hi)
            if pivot > find:
                hi = pivot - 1
            elif pivot < find:
                lo = pivot + 1
            else:
                break
        return nums[find]

    def partition(self, nums: List[int], lo: int, hi: int):
        pivot = nums[lo]
        i = lo
        j = hi + 1
        while True:
            while True:
                i += 1
                if not (nums[i] < pivot and i < hi): break
            while True:
                j -= 1
                if not (nums[j] > pivot and j > lo): break
            if i >= j: break
            self.swap(nums, i, j)
        self.swap(nums, lo, j)
        return j

    def swap(self, nums: List[int], a: int, b: int):
        nums[a], nums[b] = nums[b], nums[a]

    def shuffle(self, nums):
        for i in range(len(nums)):
            r = random.randrange(0, i + 1)
            self.swap(nums, i, r)
