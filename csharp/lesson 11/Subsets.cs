// https://leetcode.com/problems/subsets/

public class Solution
{
    public IList<IList<int>> Subsets(int[] nums)
    {
        var result = new List<IList<int>>();
        Subsets(nums, 0, new LinkedList<int>(), result);
        return result;
    }
    
    private void Subsets(int[] nums, int start, LinkedList<int> current, IList<IList<int>> result)
    {
        result.Add(new List<int>(current));
        
        for (var i = start; i < nums.Length; i++)
        {
            current.AddLast(nums[i]);
            Subsets(nums, i + 1, current, result);
            current.RemoveLast();
        }
    }
}
