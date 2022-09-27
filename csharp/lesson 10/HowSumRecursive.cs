class Solution
{
    public IList<int> HowSum(int targetSum, int[] numbers)
    {
        var dp = new List<int>[targetSum + 1];
        return HowSum(targetSum, numbers, dp);
    }

    public IList<int> HowSum(int targetSum, int[] numbers, IList<int>[] dp)
    {
        if (targetSum < 0) return null;
        if (targetSum == 0) return new List<int>();
        if (dp[targetSum] != null) return dp[targetSum];

        foreach (int number in numbers)
        {
            var current = HowSum(targetSum - number, numbers, dp);
            if (current != null)
            {
                current.Add (number);
                dp[targetSum] = current;
                return dp[targetSum];
            }
        }

        return null;
    }
}
