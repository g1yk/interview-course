from typing import List


class Solution:
    def pivot_index(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return -1
        
        sums = [None] * len(nums)
        sums[0] = nums[0]
        for i in range(1, len(nums)):
            sums[i] = sums[i - 1] + nums[i]
            
        for i, _ in enumerate(nums):
            left =  0 if i == 0  else sums[i - 1]
            right = sums[len(sums) - 1] - sums[i]
            if left == right:
                return i
        
        return -1
