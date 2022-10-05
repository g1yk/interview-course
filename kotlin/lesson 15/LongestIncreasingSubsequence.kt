// https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val piles = mutableListOf<Int>()
        
        for (num in nums) {
            val toInsert = searchInsert(piles, num)
            if (toInsert == piles.size) {
                piles.add(num)
            } else {
                piles[toInsert] = num
            }
        }
        
        return piles.size
    }
    
    fun searchInsert(piles: List<Int>, target: Int): Int {
        var lo = 0
        var hi = piles.size - 1
        
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            val value = piles[mid]
            if (value == target) {
                return mid
            } else if (value < target) {
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }
        
        return lo
    }
}
