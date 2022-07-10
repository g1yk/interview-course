// https://leetcode.com/problems/sort-an-array/

class Solution 
{
    public int[] SortArray(int[] nums)
    {
        var n = nums.Length;
        for (int i = n / 2; i >= 1; i--)
        {
            Sink(nums, i, n);
        }

        while (n > 1)
        {
            Swap(nums, 1, n);
            n--;
            Sink(nums, 1, n);
        }

        return nums;
    }

    private void Sink(int[] nums, int k, int count)
    {
        while (2 * k <= count)
        {
            var j = 2 * k;
            if (j < count && Less(nums, j, j + 1))
            {
                j++;
            }

            if (!Less(nums, k, j))
            {
                break;
            }

            Swap(nums, k, j);
            k = j;
        }
    }

    private void Swap(int[] nums, int i, int j)
    {
        var temp = nums[i - 1];
        nums[i - 1] = nums[j - 1];
        nums[j - 1] = temp;
    }

    private bool Less(int[] nums, int i, int j)
    {
        return nums[i - 1] < nums[j - 1];
    }
}
