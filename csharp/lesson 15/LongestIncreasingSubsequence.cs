// https://leetcode.com/problems/longest-increasing-subsequence/

public class Solution
{
    public int LengthOfLIS(int[] nums)
    {
        var piles = new List<int>();
        
        foreach (var num in nums)
        {
            var toInsert = SearchInsert(piles, num);
            if (toInsert == piles.Count)
            {
                piles.Add(num);
            } 
            else
            {
                piles[toInsert] = num;
            }
        }
        
        return piles.Count;
    }
    
    private int SearchInsert(List<int> piles, int target)
    {
        int lo = 0;
        int hi = piles.Count - 1;
        
        while (lo <= hi)
        {
            var mid = lo + (hi - lo) / 2;
            var value = piles[mid];            
            if (value == target)
            {
                return mid;
            } 
            else if (value < target) 
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}

