public class Examples {
    public int sum(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }

    public int countZeroSumNotOptimized(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 0)
                    result++;
            }
        }
        return result;
    }

    public int sumRecursive(int[] nums) {
        return sumRecursiveImpl(nums, 0);
    }

    private int sumRecursiveImpl(int[] nums, int current) {
        if (current >= nums.length) return 0;

        return nums[current] + sumRecursiveImpl(nums, current + 1);
    }
}
