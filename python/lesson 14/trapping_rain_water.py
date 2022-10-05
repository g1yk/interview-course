# https://leetcode.com/problems/trapping-rain-water/

class Solution:
    def trap(self, height: List[int]) -> int:
        leftMax = [0] * len(height)
        leftMax[0] = height[0]
        for i in range(1, len(height)):
            leftMax[i] = max([height[i], leftMax[i - 1]])

        rightMax = [0] * len(height)
        rightMax[len(height) - 1] = height[len(height) - 1]
        for i in range(len(height) - 2, 0, -1):
            rightMax[i] = max(height[i], rightMax[i + 1])
        
        result = 0
        for i in range(1, len(height) - 1):
            result += min(leftMax[i], rightMax[i]) - height[i]
        
        return result