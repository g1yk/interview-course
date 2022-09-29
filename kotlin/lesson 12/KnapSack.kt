// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

// Function to return max value that can be put in knapsack of capacity W.
fun knapSack(W: Int, wt: IntArray, values: IntArray, n: Int): Int {
    val dp =  Array(n + 1) { Array<Int?>(W + 1) { null } } 
    return knapSack(0, W, wt, values, dp)
} 

fun knapSack(start: Int, capacity: Int, wt: IntArray, values: IntArray, dp: Array<Array<Int?>>): Int {
   if (start >= wt.size || capacity <= 0) return 0
   if (dp[start][capacity] != null) return dp[start][capacity]!!

   dp[start][capacity] = Math.max(
       knapSack(start + 1, capacity, wt, values, dp),
       if (capacity >= wt[start]) values[start] + knapSack(start + 1, capacity - wt[start], wt, values, dp) else -1
   );

   return dp[start][capacity]!!
}
