// https://leetcode.com/problems/fibonacci-number/

class Solution {
    fun fib(n: Int): Int {
        if (n <= 1) return n        
        return fib(n, IntArray(n + 1))
    }
    
    fun fib(n: Int, dp: IntArray): Int {
        if (n <= 1) return n
        if (dp[n] != 0) return dp[n]
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp)
        return dp[n]
    }
}