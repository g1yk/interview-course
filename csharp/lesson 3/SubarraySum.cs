using System;
using System.Collections.Generic;


// https://leetcode.com/problems/subarray-sum-equals-k/
public class Solution 
{
    public int SubarraySum(int[] nums, int k) 
    {
        var sums = new Dictionary<int, int>() { {0, 1} };
        
        int result = 0, sum = 0;
        foreach (var num in nums) 
        {            
            sum += num;
            result += sums.GetValueOrDefault(sum - k, 0);
            sums[sum] = sums.GetValueOrDefault(sum, 0) + 1;
        }
        
        return result;
    }
}