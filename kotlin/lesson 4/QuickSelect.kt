// https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        shuffle(nums);
        val find = nums.size - k
        var lo = 0
        var hi = nums.size - 1
        while (lo < hi) {
            val pivot = partition(nums, lo, hi)
            if (pivot > find) hi = pivot - 1
            else if (pivot < find) lo = pivot + 1
            else break
        }
        return nums[find]
    }

    private fun partition(nums: IntArray, lo: Int, hi: Int): Int {
        val pivot = nums[lo]
        var i = lo
        var j = hi + 1
        while (true) {
            while (nums[++i] < pivot && i < hi) {}
            while (nums[--j] > pivot && j > lo) {}
            if (i >= j) break
            swap(nums, i, j)
        }
        swap(nums, lo, j)
        return j
    }

    private fun swap(nums: IntArray, a: Int, b: Int) {
        nums[a] = nums[b].also { nums[b] = nums[a] }
    }

    private fun shuffle(nums: IntArray) {
        for (i in nums.indices) {
            val r = (0 until i + 1).random()
            swap(nums, i, r)
        }
    }
}
