// https://leetcode.com/problems/sort-an-array/

class Solution {
    fun sortArray(nums: IntArray): IntArray {
        quickSort(nums)
        return nums
    }

    private fun quickSort(nums: IntArray) {
        shuffle(nums)
        sort(nums, 0, nums.size - 1)
    }

    private fun sort(nums: IntArray, lo: Int, hi: Int) {
        if (lo >= hi) return
        val pivot = partition(nums, lo, hi)
        sort(nums, lo, pivot - 1)
        sort(nums, pivot + 1, hi)
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

    fun shuffle(nums: IntArray) {
        for (i in nums.indices) {
            val r = (0 until i + 1).random()
            swap(nums, i, r)
        }
    }
}
