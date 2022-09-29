# // https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

class Solution
    # Function to return max value that can be put in knapsack of capacity W.
    def knap_sack(w, wt, val, n)
        dp = Array.new(w + 1) { Array.new(n + 1) }
        knap_sack_impl(0, w, wt, val, dp)
    end

    def knap_sack_impl(start, capacity, wt, val, dp)
        return 0 if start >= wt.length || capacity <= 0
        return dp[start][capacity] if dp[start][capacity] != nil
        
        dp[start][capacity] =[
            knap_sack_impl(start + 1, capacity, wt, val, dp),
            capacity >= wt[start] ? val[start] + self.knap_sack_impl(start + 1, capacity - wt[start], wt, val, dp) : -1
        ].max
        
        dp[start][capacity]
    end
end

