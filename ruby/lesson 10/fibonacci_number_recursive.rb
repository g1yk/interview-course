# https://leetcode.com/problems/fibonacci-number/

def fib(n)
    return n if n <= 1
    fib_impl(n, [0, 1])
end

def fib_impl(n, dp)
    return dp[n] unless dp[n].nil?
    dp[n] = fib_impl(n - 1, dp) + fib_impl(n - 2, dp)
end
