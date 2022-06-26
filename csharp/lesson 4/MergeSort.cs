// https://leetcode.com/problems/sort-an-array/

public class Solution 
{
    public int[] SortArray(int[] nums)
    {
        MergeSort(nums);
        return nums;
    }

    private void MergeSort(int[] nums) 
    {
        Sort(nums, 0, nums.Length - 1, new int[nums.Length]);
    }

    private void Sort(int[] nums, int lo, int hi, int[] temp)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        Sort(nums, lo, mid, temp);
        Sort(nums, mid + 1, hi, temp);
        Merge(nums, lo, mid, hi, temp);
    }

    private void Merge(int[] nums, int lo, int mid, int hi, int[] temp)
    {
        for (int k = lo; k <= hi; k++) 
        {
            temp[k] = nums[k];
        }

        int i = lo, j = mid + 1;
        for (var k = lo; k <= hi; k++)
        {
            if (i > mid) 
            {
                nums[k] = temp[j];
                j++;
            } 
            else if (j > hi) 
            {
                nums[k] = temp[i];
                i++;
            }
            else if (temp[j] < temp[i])
            {
                nums[k] = temp[j];
                j++;
            }
            else
            {
                nums[k] = temp[i];
                i++;
            }
        }
    }
}
