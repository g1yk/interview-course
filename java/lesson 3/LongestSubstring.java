import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, result = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }

            map.put(s.charAt(right), right);
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
