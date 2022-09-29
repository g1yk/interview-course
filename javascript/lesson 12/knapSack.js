// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

class Solution {

    // Function to return max value that can be put in knapsack of capacity W.
    knapSack(W, wt, val, n) { 
       const dp = [...new Array(n + 1)].map(() => [...new Array(W + 1)]);
       return this.knapSackImpl(0, W, wt, val, dp);
    }

    knapSackImpl(start, capacity, wt, val, dp) {
       if (start >= wt.length || capacity <= 0) return 0;
       if (dp[start][capacity] != null) return dp[start][capacity];

        dp[start][capacity] = Math.max(
            this.knapSackImpl(start + 1, capacity, wt, val, dp),
            capacity >= wt[start] // is there a space left for this item?
                ? val[start] + this.knapSackImpl(start + 1, capacity - wt[start], wt, val, dp)
                : -1
        );
        
        return dp[start][capacity]; 
    }
}
