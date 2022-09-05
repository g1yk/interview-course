# https://leetcode.com/problems/fibonacci-number/

class Solution:
    def fib(self, n: int) -> int:
        if n <= 1: return n
        dp = [None] * (n + 1)
        dp[0] = 0
        dp[1] = 1
        return self.fibImpl(n, dp)
    
    def fibImpl(self, n: int, dp: List[int]):
        if (dp[n] != None): return dp[n]
        dp[n] = self.fibImpl(n - 1, dp) + self.fibImpl(n - 2, dp)
        return dp[n]

