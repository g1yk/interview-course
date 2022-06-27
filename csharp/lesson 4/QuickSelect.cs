// https://leetcode.com/problems/kth-largest-element-in-an-array/

public class Solution
{
    public int FindKthLargest(int[] nums, int k)
    {
        Shuffle(nums);
        var find = nums.Length - k;
        int lo = 0, hi = nums.Length - 1;
        while (lo < hi) 
        {
            var pivot = Partition(nums, lo, hi);            
            if (pivot > find) 
            { 
                hi = pivot - 1; 
            }
            else if (pivot < find) 
            { 
                lo = pivot + 1; 
            }
            else 
            {
                break; 
            }
        }
        return nums[find];        
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