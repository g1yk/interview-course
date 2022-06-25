public class Solution
{
    public int[] TwoSum(int[] nums, int target)
    {
        var map = new Dictionary<int, int>();

        for (int i = 0; i < nums.Length; i++)
        {
            int diff = target - nums[i];
            if (map.ContainsKey(diff)) return new int[] { map[diff], i };
            map[nums[i]] = i;
        }

        return null;
    }
}
