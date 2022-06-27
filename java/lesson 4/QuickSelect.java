// https://leetcode.com/problems/kth-largest-element-in-an-array/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int find = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {            
            var pivot = partition(nums, lo, hi);            
            if (pivot > find) hi = pivot - 1;
            else if (pivot < find) lo = pivot + 1;
            else break;
        }
        return nums[find];
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] < pivot && i < hi);
            while (nums[--j] > pivot && j > lo);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);  
        return j;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int r = random.nextInt(i + 1);
            swap(nums, i, r);
        }
    }
}
