// https://leetcode.com/problems/unique-paths/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[row].length; col++) {
                if (row == 1 && col == 1) 
                    dp[row][col] = 1;
                else
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        
        return dp[m][n];
    }
}
