public class Examples
{
    public int Sum(int[] nums)
    {
        var result = 0;
        for (var i = 0; i < nums.Length; i++)
        {
            result += nums[i];
        }
        return result;
    }

    public int[][] BuildMatrix(int rows, int cols)
    {
        var result = new int[rows][];
        for (int row = 0; row < rows; row++)
        {  
            result[row] = new int[cols];
            for (int col = 0; col < cols; col++)
            {
                result[row][col] = (row + 1) * (col + 1);
            }
        }
        return result;
    }

    public int SumRecursive(int[] nums)
    {
        return SumRecursiveImpl(nums, 0);
    }

    public int SumRecursiveImpl(int[] nums, int current)
    {
        if (current >= nums.Length) return 0;

        return nums[current] + SumRecursiveImpl(nums, current + 1);
    }
}
