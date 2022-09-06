# https://leetcode.com/problems/unique-paths/

def unique_paths(m, n)
    dp = Array.new(m + 1) { Array.new(n + 1) }
    dp[1][1] = 1
    unique_paths_impl(m, n, dp)
end


def unique_paths_impl(row, col, dp)
    return 0 if row < 0 || col < 0
    return dp[row][col] unless dp[row][col].nil?

    dp[row][col] = unique_paths_impl(row - 1, col, dp) + unique_paths_impl(row, col - 1, dp)
end
