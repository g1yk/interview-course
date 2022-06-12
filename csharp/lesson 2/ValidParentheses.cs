// https://leetcode.com/problems/valid-parentheses/

class Solution 
{
    public bool IsValid(String s) 
    {
        Stack<char> stack = new Stack<char>();        
        foreach (char c in s)
        {
            if (c == '(' || c == '{' || c == '[')
            {
                stack.Push(c);
            } 
            else 
            {
                if (stack.Count == 0) return false;
                char o = stack.Pop();
                if (o == '{' && c != '}' || o == '(' && c != ')' || o == '[' && c != ']' ) return false;
            }
        }
        return stack.Count == 0;
    }
}
