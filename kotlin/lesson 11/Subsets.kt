// https://leetcode.com/problems/subsets/

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        subsets(nums, 0, LinkedList<Int>(), result)
        return result
    }
    
    fun subsets(nums: IntArray, start: Int, current: LinkedList<Int>, result: MutableList<List<Int>>) {
        result.add(ArrayList(current))
        
        for (i in start..nums.size - 1) {
            current.add(nums[i])
            subsets(nums, i + 1, current, result)
            current.removeLast()
        }
    }
}
