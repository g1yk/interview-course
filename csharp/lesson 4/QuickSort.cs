// https://leetcode.com/problems/sort-an-array/

public class Solution
{
    public int[] SortArray(int[] nums)
    {
        QuickSort(nums);
        return nums;
    }

    private void QuickSort(int[] nums)
    {
        Shuffle(nums);
        Sort(nums, 0, nums.Length - 1);
    }

    private void Sort(int[] nums, int lo, int hi)
    {
        if (lo >= hi) return;
        int pivot = Partition(nums, lo, hi);
        Sort(nums, lo, pivot - 1);
        Sort(nums, pivot + 1, hi);
    }

    private int Partition(int[] nums, int lo, int hi)
    {
        int pivot = nums[lo];
        int i = lo, j = hi + 1;
        while (true)
        {
            while (nums[++i] < pivot && i < hi);
            while (nums[--j] > pivot && j > lo);
            if (i >= j) break;
            Swap(nums, i, j);
        }
        Swap(nums, lo, j);
        return j;
    }

    private void Swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void Shuffle(int[] nums)
    {
        Random random = new Random();
        for (int i = 0; i < nums.Length; i++)
        {
            int r = random.Next(i + 1);
            Swap(nums, i, r);
        }
    }
}
