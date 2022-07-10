// https://leetcode.com/problems/sort-an-array/

class Solution {
    fun sortArray(nums: IntArray): IntArray {
        var n = nums.size
        for (i in n / 2 .. 1) {
            sink(nums, i, n)
        }

        while (n > 1) {
            swap(nums, 1, n)
            n--
            sink(nums, 1, n)
        }

        return nums
    }

    private fun sink(nums: IntArray, index: Int, count: Int) {
        var k = index
        while (2 * k <= count) {
            var j = 2 * k
            if (j < count && less(nums, j, j + 1)) {
                j++
            }
            if (!less(nums, k, j)) {
                break
            }
            swap(nums, k, j)
            k = j
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        nums[i - 1] = nums[j - 1].also { nums[j - 1] = nums[i - 1] }
    }

    private fun less(nums: IntArray, i: Int, j: Int): Boolean {
        return nums[i - 1] < nums[j - 1]
    }
}
