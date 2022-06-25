# https://leetcode.com/problems/longest-substring-without-repeating-characters
def length_of_longest_substring(s)
    left = right = result = 0
    map = {}

    while right < s.length
        left = [left, map[s[right]] + 1].max if map.key?(s[right])
        map[s[right]] = right
        result = [result, right - left + 1].max
        right += 1
    end

    result
end
