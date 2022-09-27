import java.util.*;

class Solution {

    public List<Integer> howSum(int targetSum, int[] numbers) {
        Integer[] dp = new Integer[targetSum + 1];
        dp[0] = 0;

        for (int i = 0; i <= targetSum; i++) {
            if (dp[i] == null) continue;            
            for (int number : numbers) {
    		    if (i + number > targetSum) continue;
                dp[i + number] = number;
                if (i + number == targetSum) break;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int current = targetSum;
        while (dp[current] != null && current != 0) {
            result.add(dp[current]);
            current = current - dp[current];
        }
        return result;
    }
}