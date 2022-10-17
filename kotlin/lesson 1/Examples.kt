public class Examples {
    fun sum(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            result += nums[i]
        }
        return result
    }

    fun buildMatrix(rows: Int, cols: Int): Array<IntArray> {
        val result = Array(rows) { IntArray(cols) }
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                result[row][col] = (row + 1) * (col + 1)
            }  
        }
        return result
    }

    fun sumRecursive(nums: IntArray): Int {
        return sumRecursiveImpl(nums, 0)
    }

    fun sumRecursiveImpl(nums: IntArray, current: Int): Int {
        if (current >= nums.size) return 0

        return nums[current] + sumRecursiveImpl(nums, current + 1)
    }
}
