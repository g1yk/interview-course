class Solution {
    fun binarySearch(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.lastIndex

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (nums[mid] > target) {
                hi = mid - 1
            } else if (nums[mid] < target) {
                lo = mid + 1
            } else {
                return mid
            }
        }

        return -1
    }
}
