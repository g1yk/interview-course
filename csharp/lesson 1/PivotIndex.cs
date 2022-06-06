public class Solution {
    public int PivotIndex(int[] nums) {
        if (nums.Length == 0) return -1;
        
        var sums = new int[nums.Length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.Length; i++) {
           sums[i] = sums[i - 1] + nums[i];
        }

        for (int i = 0; i < sums.Length; i++) {
            var left = i == 0 ? 0 : sums[i - 1];
            var right = sums[sums.Length - 1] - sums[i];
            if (left == right) return i;
        }
        
        return -1;
    }
}
