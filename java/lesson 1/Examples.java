public class Examples {
    public int sum(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }

    public int[][] buildMatrix(int rows, int cols) {      
        int[][] result = new int[rows][cols];
        for (int row = 0; row < rows; row++) {  
            for (int col = 0; col < cols; col++) {  
                result[row][col] = (row + 1) * (col + 1);
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
