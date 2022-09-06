// https://leetcode.com/problems/unique-paths/

public class Solution
{
    public int UniquePaths(int m, int n)
    {
        var dp = new int[m + 1][];
        for (var i = 0; i < dp.Length; i++) dp[i] = new int[n + 1];
        
        dp[1][1] = 1;
        return UniquePaths(m, n, dp);
    }
    
    private int UniquePaths(int row, int col, int[][] dp)
    {
        if (row < 0 || col < 0) return 0;
        if (dp[row][col] > 0) return dp[row][col];
        
        dp[row][col] = UniquePaths(row - 1, col, dp) + UniquePaths(row, col - 1, dp);
        return dp[row][col];
    }
}
