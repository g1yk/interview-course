// https://leetcode.com/problems/fibonacci-number/

function fib(n) {
    if (n <= 1) return n;
    return fibo(n, [0, 1]);
}

function fibo(n, dp) {
    if (dp[n] !== undefined) return dp[n];
    dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
    return dp[n];
}
