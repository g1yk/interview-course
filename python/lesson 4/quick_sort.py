import random
from typing import List

# https://leetcode.com/problems/sort-an-array/
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.quick_sort(nums)
        return nums
    
    def quick_sort(self, nums: List[int]):
        self.shuffle(nums)
        self.sort(nums, 0, len(nums) - 1)
    
    def sort(self, nums: List[int], lo: int, hi: int):
        if hi <= lo: return
        pivot = self.partition(nums, lo, hi)
        self.sort(nums, lo, pivot - 1)
        self.sort(nums, pivot + 1, hi)
    
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
