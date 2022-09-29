# // https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

class Solution:
    
    # Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self, W, wt, val, n):
        dp = [[ None for row in range(W + 1) ] for col in range(n + 1)]
        return self.knapSackImpl(0, W, wt, val, dp)

    def knapSackImpl(self, start, capacity, wt, val, dp):
        if start >= len(wt) or capacity <= 0: return 0
        if dp[start][capacity] != None: return dp[start][capacity]

        dp[start][capacity] = max(
            self.knapSackImpl(start + 1, capacity, wt, val, dp),
            val[start] + self.knapSackImpl(start + 1, capacity - wt[start], wt, val, dp) if capacity >= wt[start] else -1
        )

        return dp[start][capacity]
