// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    public int knapSack(int W, int wt[], int val[], int n) {
        Integer[][] dp = new Integer[n + 1][W + 1];
        return knapSack(0, W, wt, val, dp);
    }

    private int knapSack(int start, int capacity, int wt[], int val[], Integer[][] dp) {
        if (start >= wt.length || capacity <= 0) return 0;
        if (dp[start][capacity] != null) return dp[start][capacity];

        dp[start][capacity] = Math.max(
                knapSack(start + 1, capacity, wt, val, dp),
                capacity >= wt[start] // is there a space left for this item?
                        ? val[start] + knapSack(start + 1, capacity - wt[start], wt, val, dp)
                        : -1);

        return dp[start][capacity];
    }
}
