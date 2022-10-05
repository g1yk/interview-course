# https://leetcode.com/problems/longest-increasing-subsequence/

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        piles = []    
        for num in nums:
            toInsert = self.searchInsert(piles, num)
            if toInsert == len(piles):
                piles.append(num)
            else:
                piles[toInsert] = num
        return len(piles)

    def searchInsert(self, nums: List[int], target: int) -> int:
        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if target < nums[mid]:
                hi = mid - 1
            elif target > nums[mid]:
                lo = mid + 1
            else:
                return mid
        return lo
