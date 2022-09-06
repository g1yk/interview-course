// https://leetcode.com/problems/unique-paths/

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        var dp = Array(m + 1, { i -> Array(n + 1, { j -> 0 }) })
        for (row in 1..dp.size - 1) {
            for (col in 1..dp[row].size - 1) {
                dp[row][col] = if (row == 1 || col == 1) 1 else dp[row - 1][col] + dp[row][col - 1]
            }
        }
        return dp[m][n]
    }
}