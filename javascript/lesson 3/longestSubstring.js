// https://leetcode.com/problems/longest-substring-without-repeating-characters

function lengthOfLongestSubstring(s) {
    let left = 0, right = 0, result = 0;
    const map = new Map();

    while (right < s.length) {
        if (map.has(s[right])) {
            left = Math.max(left, map.get(s[right]) + 1);
        }

        map.set(s[right], right);
        result = Math.max(result, right - left + 1);
        right++;
    }

    return result;
}
