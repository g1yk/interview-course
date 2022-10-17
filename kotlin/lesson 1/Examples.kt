public class Examples {
    fun sum(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            result += nums[i]
        }
        return result
    }

    fun countZeroSumNotOptimized(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == 0)
                    result++
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
