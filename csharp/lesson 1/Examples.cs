public class Examples
{
    public int Sum(int[] nums)
    {
        var result = 0;
        for (var i = 0; i < nums.Length; i++)
        {
            result += nums[i];
        }
        return result;
    }

    public int CountZeroSumNotOptimized(int[] nums)
    {
        int result = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            for (int j = i + 1; j < nums.Length; j++)
            {
                if (nums[i] + nums[j] == 0)
                    result++;
            }
        }
        return result;
    }

    public int SumRecursive(int[] nums)
    {
        return SumRecursiveImpl(nums, 0);
    }

    public int SumRecursiveImpl(int[] nums, int current)
    {
        if (current >= nums.Length) return 0;

        return nums[current] + SumRecursiveImpl(nums, current + 1);
    }
}
