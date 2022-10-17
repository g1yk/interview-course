class Examples:
    def sum(self, nums: List[int]) -> int:
        result = 0
        for i in range(len(nums)):
            result += nums[i]
        return result

    def buildMatrix(self, rows: int, cols: int) -> List[List[int]]:
        result = [None] * rows
        for row in range(rows):
            result[row] = [None] * cols
            for col in range(cols):
                result[row][col] = (row + 1) * (col + 1)                
        return result

    def sumRecursive(self, nums: List[int]) -> int:
        return self.sumRecursiveImpl(nums, 0)

    def sumRecursiveImpl(self, nums: List[int], current: int) -> int:
        if current >= len(nums): return 0
        return nums[current] + self.sumRecursiveImpl(nums, current + 1)
