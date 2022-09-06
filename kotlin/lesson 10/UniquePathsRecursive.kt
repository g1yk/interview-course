// https://leetcode.com/problems/unique-paths/

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        var dp = Array(m + 1, { i -> Array(n + 1, { j -> 0 }) })
        dp[1][1] = 1
        return uniquePaths(m, n, dp);
    }
    
    
    fun uniquePaths(row: Int, col: Int, dp: Array<Array<Int>>): Int {
        if (row < 0 || col < 0) return 0
        if (dp[row][col] > 0) return dp[row][col]
        
        dp[row][col] = uniquePaths(row - 1, col, dp) + uniquePaths(row, col - 1, dp)
        return dp[row][col]
    }
}
