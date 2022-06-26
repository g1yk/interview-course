# https://leetcode.com/problems/subarray-sum-equals-k/

from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        sums = { 0: 1 }
        result = sum = 0
        for num in nums:
            sum += num
            result += sums.get(sum - k, 0)
            sums[sum] = sums.get(sum, 0) + 1
        return result
