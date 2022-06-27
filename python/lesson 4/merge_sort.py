from typing import List

# https://leetcode.com/problems/sort-an-array/
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.merge_sort(nums)
        return nums

    def merge_sort(self, nums: List[int]):
        return self.sort(nums, 0, len(nums) - 1, [0] * len(nums))

    def sort(self, nums: List[int], lo: int, hi: int, temp: List[int]):
        if hi <= lo: return
        mid = lo + (hi - lo) // 2
        self.sort(nums, lo, mid, temp)
        self.sort(nums, mid + 1, hi, temp)
        self.merge(nums, lo, mid, hi, temp)

    def merge(self, nums: List[int], lo: int, mid: int, hi: int, temp: List[int]):
        for i in range(lo, hi + 1):
            temp[i] = nums[i]

        i = lo
        j = mid + 1
        for k in range(lo, hi + 1):
            if i > mid:
                nums[k] = temp[j]
                j += 1
            elif j > hi:
                nums[k] = temp[i]
                i += 1
            elif temp[j] < temp[i]:
                nums[k] = temp[j]
                j += 1
            else:
                nums[k] = temp[i]
                i += 1
