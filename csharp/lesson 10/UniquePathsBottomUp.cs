// https://leetcode.com/problems/unique-paths/

public class Solution
{
    public int UniquePaths(int m, int n)
    {
        var dp = new int[m + 1][];
        for (var i = 0; i < dp.Length; i++)
        {
            dp[i] = new int[n + 1];
        }
        
        for (int row = 1; row < dp.Length; row++)
        {
            for (int col = 1; col < dp[row].Length; col++)
            {
                if (row == 1 && col == 1)
                {
                    dp[row][col] = 1;
                }
                else
                {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}

