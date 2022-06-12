// https://leetcode.com/problems/valid-parentheses/

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c)
            } else {
                if (stack.isEmpty()) return false
                val o = stack.pop()
                if (o == '{' && c != '}' || o == '(' && c != ')' || o == '[' && c != ']' ) return false
            }
        }        
        return stack.isEmpty()
    }
}
