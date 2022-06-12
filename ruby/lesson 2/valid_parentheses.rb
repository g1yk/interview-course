# https://leetcode.com/problems/valid-parentheses/

def is_valid(s)
    stack = []
    s.each_char do |c|
        if c == '(' || c == '{' || c == '['
            stack.push(c)
        else
            return false if stack.empty?
            o = stack.pop
            return false if o == '{' && c != '}' || o == '(' && c != ')' || o == '[' && c != ']'
        end
    end
    stack.empty?
end
