class Solution
{
    public List<int> HowSum(int targetSum, int[] numbers)
    {
        var dp = new int?[targetSum + 1];
        dp[0] = 0;

        for (int i = 0; i <= targetSum; i++)
        {
            if (dp[i] == null) continue;            
            foreach (var number in numbers)
            {
                if (i + number > targetSum) continue;
                dp[i + number] = number;
                if (i + number == targetSum) break;
            }
        }

        var result = new List<int>();
        var current = targetSum;
        while (dp[current] != null && current != 0)
        {
            result.Add(dp[current].Value);
            current = current - dp[current].Value;
        }
        return result;
    }
}
