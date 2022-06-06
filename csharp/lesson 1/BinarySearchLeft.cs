public class Solution
{
    public int BinarySearchLeft(int[] nums, int target) 
    {
        var lo = 0;
        var hi = nums.Length - 1;

        while (lo <= hi)
        {
            var mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) 
            {
                hi = mid - 1;
            }
            else if (nums[mid] < target) 
            {
                lo = mid + 1;
            }
            else 
            {
                if (mid == 0 || nums[mid - 1] < target) return mid;
                hi = mid - 1;
            }
        }

        return -1;
    }
}
