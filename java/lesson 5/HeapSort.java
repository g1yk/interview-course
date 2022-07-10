// https://leetcode.com/problems/sort-an-array/

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i >= 1; i--) {
            sink(nums, i, n);
        }

        while (n > 1) {
            swap(nums, 1, n);
            n--;
            sink(nums, 1, n);
        }

        return nums;
    }

    private void sink(int[] items, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(items, j, j + 1)) {
                j++;
            }
            if (less(items, j, k)) {
                break;
            }
            swap(items, k, j);
            k = j;
        }
    }

    private void swap(int[] items, int a, int b) {
        int temp = items[a - 1];
        items[a - 1] = items[b - 1];
        items[b - 1] = temp;
    }

    private boolean less(int[] items, int a, int b) {
        return items[a - 1] < items[b - 1];
    }
}
