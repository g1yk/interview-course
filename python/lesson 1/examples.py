class Examples:
    def sum(self, nums: List[int]) -> int:
        result = 0
        for i in range(len(nums)):
            result += nums[i]
        return result

    def countZeroSumNotOptimized(self, nums: List[int]) -> int:
        result = 0
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):        
                if nums[i] + nums[j] == 0:
                    result += 1        
        return result

    def sumRecursive(self, nums: List[int]) -> int:
        return self.sumRecursiveImpl(nums, 0)

    def sumRecursiveImpl(self, nums: List[int], current: int) -> int:
        if current >= len(nums): return 0
        return nums[current] + self.sumRecursiveImpl(nums, current + 1)
