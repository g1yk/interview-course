// https://leetcode.com/problems/sort-an-array/

class Solution {
    fun sortArray(nums: IntArray): IntArray {
        mergeSort(nums)
        return nums
    }

    fun mergeSort(nums: IntArray) {
        sort(nums, 0, nums.size - 1, IntArray(nums.size))
    }

    fun sort(nums: IntArray, lo: Int, hi: Int, temp: IntArray) {
        if (hi <= lo) return
        val mid = lo + (hi - lo) / 2
        sort(nums, lo, mid, temp)
        sort(nums, mid + 1, hi, temp)
        merge(nums, lo, mid, hi, temp)
    }

    fun merge(nums: IntArray, lo: Int, mid: Int, hi: Int, temp: IntArray) {
        for (i in lo.. hi) {
            temp[i] = nums[i]
        }

        var i = lo
        var j = mid + 1
        for (k in lo..hi) {
            if (i > mid) {
                nums[k] = temp[j]
                j++
            } else if (j > hi) {
                nums[k] = temp[i]
                i++
            } else if (temp[j] < temp[i]) {
                nums[k] = temp[j]
                j++
            } else {
                nums[k] = temp[i]
                i++
            }
        }
    }
}

