class Solution {
    fun pivotIndex(nums: IntArray): Int {
        if (nums.size == 0) return -1
        
        val sums = IntArray(nums.size) { nums[0] }
        for (i in 1 until nums.size) {
           sums[i] = sums[i - 1] + nums[i]
        }

        for (i in sums.indices) {
            val left = if (i == 0) 0 else sums[i - 1]
            val right = sums[sums.size - 1] - sums[i]
            if (left == right) return i
        }
        
        return -1
    }
}
