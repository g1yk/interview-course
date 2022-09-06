# https://leetcode.com/problems/unique-paths/

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [ [ 0 for row in range(n + 1) ] for col in range(m + 1) ]
        for row in range(1, m + 1):
            for col in range(1, n + 1):
                if row == 1 or col == 1:
                    dp[row][col] = 1
                else:
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1]
        return dp[m][n]
