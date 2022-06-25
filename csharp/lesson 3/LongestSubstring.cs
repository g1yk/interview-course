using System;
using System.Collections.Generic;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Solution
{
    public int LengthOfLongestSubstring(string s)
    {
        int left = 0, right = 0, result = 0;
        var map = new Dictionary<char, int>();

        while (right < s.Length)
        {
            if (map.ContainsKey(s[right]))
            {
                left = Math.Max(left, map[s[right]] + 1);
            }

            map[s[right]] = right;
            result = Math.Max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
