from typing import List


class Solution:
    def binarySearchLeft(self, nums: List[int], target: int) -> int:
        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if target < nums[mid]:
                hi = mid - 1
            elif target > nums[mid]:
                lo = mid + 1
            else:
                if mid == 0 or nums[mid - 1] < target:
                    return mid
                hi = mid - 1
        return -1
