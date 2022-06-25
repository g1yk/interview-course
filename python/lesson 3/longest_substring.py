# https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = right = result = 0
        map = dict()

        while right < len(s):
            if s[right] in map:
                left = max(left, map[s[right]] + 1)

            map[s[right]] = right
            result = max(result, right - left + 1)
            right += 1

        return result
