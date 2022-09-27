// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

public class Solution
{
    public int FindMinArrowShots(int[][] points)
    {
        Array.Sort(points, (a, b) => a[1].CompareTo(b[1]));
        
        var result = 1;
        var prev = points[0];
        for (var i = 1; i < points.Length; i++)
        {
            var current = points[i];
            if (current[0] > prev[1])
            {
                prev = current;
                result++;
            }
        }
        return result;
    }
}
