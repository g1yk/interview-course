from typing import List


class Solution:
    def countingSort(self, nums: List[int], max: int):
        freq = [0] * (max + 1)
        for num in nums: freq[num] += 1
        
        current = 0    
        for i, f in enumerate(freq):
            for _ in range(f):
                nums[current] = i
                current += 1
