class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val sums = mutableMapOf(0 to 1)        
        var result = 0
        var sum = 0
        for (num in nums) {            
            sum += num
            result += sums.getOrDefault(sum - k, 0)
            sums[sum] = sums.getOrDefault(sum, 0) + 1
        }
        
        return result
    }
}
