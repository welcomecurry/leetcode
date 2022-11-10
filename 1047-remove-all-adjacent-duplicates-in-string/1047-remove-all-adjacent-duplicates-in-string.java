class Solution {
    public String removeDuplicates(String S) {
        //create stack
        //loop through the string
        //if stack is not empty and stack.peek == c
        //stack.pop
        //else stack.push
        //loop through stack
        //append it string builder 
        //return reversed sb.toString since stack is reversed
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : S.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek() == c)
            {
                stack.pop();
            }
            else
            {
                stack.push(c);
            }
        }
        
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}