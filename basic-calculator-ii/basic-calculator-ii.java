class Solution {
    public int calculate(String s) {
        //we need to perform * and / operations first
        //init stack, curr operation and currNum
        //loop through string
        //check for digit or operation
        //if digit just append to currNum
        //if operation, perform operation and push onto stack then rest currNum and set operation
        //stack will be filled with all calculated values, sum it up and return the result
        
        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char operation = '+';
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) //digit check
            {
                currNum = (currNum * 10) + (ch - '0');
            }
            
            if(!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) //operation check
            {
                if(operation == '+')
                {
                    stack.push(currNum);
                }
                else if(operation == '-')
                {
                    stack.push(-currNum);
                }
                else if(operation == '*')
                {
                    stack.push(stack.pop() * currNum);
                }
                else if(operation == '/')
                {
                    stack.push(stack.pop() / currNum);
                }
                
                currNum = 0;
                operation = ch;
            }
        }
        
        int result = 0;
        
        while(!stack.isEmpty()) result += stack.pop();
        
        return result;
    }
}