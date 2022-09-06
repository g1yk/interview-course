// https://leetcode.com/problems/unique-paths/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        return uniquePaths(m, n, dp);
    }
    
    private int uniquePaths(int row, int col, int[][] dp) {
        if (row < 0 || col < 0) return 0;
        if (dp[row][col] > 0) return dp[row][col];
        
        dp[row][col] = uniquePaths(row - 1, col, dp) + uniquePaths(row, col - 1, dp);
        return dp[row][col];
    }
}
