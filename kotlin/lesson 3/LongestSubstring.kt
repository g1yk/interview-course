// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var right = 0
        var result = 0
        val map = mutableMapOf<Char, Int>()

        while (right < s.length) {
            if (map.containsKey(s[right])) {
                left = Math.max(left, map[s[right]]!! + 1)
            }

            map[s[right]] = right
            result = Math.max(result, right - left + 1)
            right++
        }

        return result
    }
}
