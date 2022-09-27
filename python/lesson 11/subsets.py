# https://leetcode.com/problems/subsets/

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.subsetsImpl(nums, 0, [], result)
        return result
        
    def subsetsImpl(self, nums: List[int], start: int, current: List[int], result: List[List[int]]):
        result.append(current.copy())
    
        for i in range(start, len(nums)):
            current.append(nums[i])
            self.subsetsImpl(nums, i + 1, current, result)
            current.pop()
