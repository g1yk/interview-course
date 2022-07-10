import random
from typing import List

# https://leetcode.com/problems/sort-an-array/


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        for i in range(n // 2, 0, -1):
            self.sink(nums, i, n)

        while n > 1:
            self.swap(nums, 1, n)
            n -= 1
            self.sink(nums, 1, n)

        return nums

    def sink(self, nums: List[int], k: int, count: int):
        while 2 * k <= count:
            j = 2 * k
            if j < count and self.less(nums, j, j + 1):
                j += 1
            if not self.less(nums, k, j):
                break
            self.swap(nums, k, j)
            k = j

    def swap(self, nums: List[int], i: int, j: int):
        nums[i - 1], nums[j - 1] = nums[j - 1], nums[i - 1]

    def less(self, nums: List[int], i: int, j: int):
        return nums[i - 1] < nums[j - 1]
