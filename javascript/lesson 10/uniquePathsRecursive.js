// https://leetcode.com/problems/unique-paths/

function uniquePaths(m, n) {
    const dp = Array.from(Array(m + 1), () => new Array(n + 1));
    dp[1][1] = 1;
    return uniquePathsImpl(m, n, dp);
}

function uniquePathsImpl(row, col, dp) {
    if (row < 0 || col < 0) return 0;
    if (dp[row][col] > 0) return dp[row][col];

    dp[row][col] = uniquePathsImpl(row - 1, col, dp) + uniquePathsImpl(row, col - 1, dp);
    return dp[row][col];
}
