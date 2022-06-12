import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char o = stack.pop();
                if (o == '{' && c != '}' || o == '(' && c != ')' || o == '[' && c != ']' ) return false;
            }
        }
        return stack.isEmpty();
    }
}
