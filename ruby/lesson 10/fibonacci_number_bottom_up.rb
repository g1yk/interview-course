# https://leetcode.com/problems/fibonacci-number/

def fib(n)
    return n if n <= 1
    dp = [0, 1]
    (2..n).each { |i| dp[i] = dp[i - 1] + dp[i - 2] }
    dp[n]
end
