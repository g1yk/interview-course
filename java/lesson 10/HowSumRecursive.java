import java.util.*;

class Solution {

    public List<Integer> howSum(int targetSum, int[] numbers) {        
        List<Integer>[] dp = (List<Integer>[]) new ArrayList[targetSum + 1];
        return howSum(targetSum, numbers, dp);
    }

    public List<Integer> howSum(int targetSum, int[] numbers,  List<Integer>[] dp) {
        if (targetSum < 0) return null;
        if (targetSum == 0) return new ArrayList<Integer>();
        if (dp[targetSum] != null) return dp[targetSum];        
        
        for (int number : numbers) {
            List<Integer> current = howSum(targetSum - number, numbers, dp);
            if (current != null) {
                current.add(number);
                dp[targetSum] = current;
                return dp[targetSum];
            }
        }
        
        return null;
    }
}
