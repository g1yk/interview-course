// https://leetcode.com/problems/fibonacci-number/

class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        Integer[] dp = new Integer[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        return fib(n, dp);
    }

    private int fib(int n, Integer[] dp) {
        if (dp[n] != null) return dp[n];
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }
}
