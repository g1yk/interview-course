// https://leetcode.com/problems/fibonacci-number/

public class Solution
{
    public int Fib(int n)
    {
        if (n <= 1) return n;
        return Fib(n, new int[n + 1]);
    }
    
    private int Fib(int n, int[] dp)
    {
        if (n <= 1) return n;
        if (dp[n] > 0) return dp[n];        
        dp[n] = Fib(n - 1, dp) + Fib(n - 2, dp);
        return dp[n];
    }
}
