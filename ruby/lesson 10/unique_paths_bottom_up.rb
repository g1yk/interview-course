# https://leetcode.com/problems/unique-paths/

def unique_paths(m, n)
    dp = Array.new(m + 1) { Array.new(n + 1) { 0 } }
    (1..m).each do |row|
        (1..n).each do |col|
            dp[row][col] = dp[row - 1][col] + dp[row][col - 1]
            dp[row][col] = 1 if row == 1 || col == 1
        end
    end
    dp[m][n]
end
