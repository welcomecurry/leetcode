class Solution {
    public boolean isValid(String s) {
        //base check if the string is not even return false
        //init stack
        //loop through s
        //if the current char is an open bracket push to stack
        //if current char is closed bracket, check stack is not empty and peek is corresponding
        //return if stack is empty
        
        if(s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray())
        {
            if(c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            }
            else if(!stack.isEmpty() && c == ')' && stack.peek() == '(')
            {
                stack.pop();
            }
            else if(!stack.isEmpty() && c == '}' && stack.peek() == '{')
            {
                stack.pop();
            }
            else if(!stack.isEmpty() && c == ']' && stack.peek() == '[')
            {
                stack.pop();
            }
            else
            {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}