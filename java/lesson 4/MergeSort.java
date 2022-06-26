// https://leetcode.com/problems/sort-an-array/

public class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }

    public void mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    public void sort(int[] nums, int lo, int hi, int[] temp) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid, temp);
        sort(nums, mid + 1, hi, temp);
        merge(nums, lo, mid, hi, temp);
    }

    private void merge(int[] nums, int lo, int mid, int hi, int[] temp) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > hi) {
                nums[k] = temp[i];
                i++;
            } else if (temp[j] < temp[i]) {
                nums[k] = temp[j];
                j++;
            } else {
                nums[k] = temp[i];
                i++;
            }
        }
    }
}
