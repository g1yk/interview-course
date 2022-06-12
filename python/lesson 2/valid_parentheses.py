# https://leetcode.com/problems/valid-parentheses/

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if  c == '(' or c == '{' or c == '[':
                stack.append(c)
            else:
                if len(stack) == 0: return False
                o = stack.pop()
                if o == '{' and c != '}' or o == '(' and c != ')' or o == '[' and c != ']': return False;        
        return len(stack) == 0