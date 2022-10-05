// https://leetcode.com/problems/trapping-rain-water/

public class Solution
{
    public int Trap(int[] height)
    {
        var maxLeft = new int[height.Length];
        maxLeft[0] = height[0];
        for (var i = 1; i < height.Length; i++) 
        {
            maxLeft[i] = Math.Max(maxLeft[i - 1], height[i]);
        }
        
        var maxRight = new int[height.Length];
        maxRight[height.Length - 1] = height[height.Length - 1];
        for (var i = height.Length - 2; i >= 0; i--) 
        {
            maxRight[i] = Math.Max(maxRight[i + 1], height[i]);
        }
        
        var sum = 0;
        for (var i = 1; i < height.Length - 1; i++)
        {
            sum += Math.Min(maxLeft[i], maxRight[i]) - height[i];
        }        
        return sum;
    }
}
