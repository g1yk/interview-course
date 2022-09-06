# https://leetcode.com/problems/unique-paths/

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [ [ 0 for row in range(n + 1) ] for col in range(m + 1) ]
        dp[1][1] = 1
        return self.uniquePathsImpl(m, n, dp)
        
    def uniquePathsImpl(self, row: int, col: int, dp: List[int]) -> int:
        if row < 0 or col < 0: return 0 
        if dp[row][col] > 0: return dp[row][col]

        dp[row][col] = self.uniquePathsImpl(row - 1, col, dp) + self.uniquePathsImpl(row, col - 1, dp)
        return dp[row][col]
