// https://leetcode.com/problems/trapping-rain-water/

class Solution {
    fun trap(height: IntArray): Int {
        val leftMax = IntArray(height.size)
        leftMax[0] = height[0]
        for (i in 1..height.size - 1) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1])
        }
        
        val rightMax = IntArray(height.size)
        rightMax[height.size - 1] = height[height.size - 1]
        for (i in height.size - 2 downTo 0) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1])
        }
        
        var result = 0
        for (i in 1..height.size - 1) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i]
        }
        
        return result
    }
}
