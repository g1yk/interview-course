// https://leetcode.com/problems/unique-paths/

function uniquePaths(m, n) {
    const dp = Array.from(Array(m + 1), () => new Array(n + 1).fill(0));
    for (let row = 1; row < dp.length; row++) {
        for (let col = 1; col < dp[row].length; col++) {
           dp[row][col] = (row == 1 && col == 1) ? 1 : dp[row - 1][col] + dp[row][col - 1];
        }
    }
    return dp[m][n];
}
