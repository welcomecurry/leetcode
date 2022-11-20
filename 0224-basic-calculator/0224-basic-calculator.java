class Solution {
    public int calculate(String s) {
        //init stack for brackets
        //init currNum, result and sign
        //loop thorugh string
        //if the current char is a num, currNum = currNum * 10 + (int)(c - '0')
        //the notation above is if we have multiple digit numbers
        //if the curr char is + then add currNum * sign to result, reset currNum and sign = 1
        //if the curr char is - then add currNum * sign to result, reset currNum and sign = -1
        //if the curr char is ( push sign and result on stack, reset sign and result
        //if the curr char is ) add currNum to result and *= the sign pop and += the result pop
        //at the end if the num != 0 add remaning
        
        Stack<Integer> stack = new Stack<>();
        int currNum = 0, result = 0, sign = 1;
        
        for(char c : s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                currNum = currNum * 10 + (int) (c - '0');
            }
            else if(c == '+')
            {
                result += currNum * sign;
                currNum = 0;
                sign = 1;
            }
            else if(c == '-')
            {
                result += currNum * sign;
                currNum = 0;
                sign = -1;
            }
            else if(c == '(')
            {
                stack.push(result);
                stack.push(sign);
                //reset to be value in brackets
                result = 0;
                sign = 1;
            }
            else if(c == ')')
            {
                result += currNum * sign;
                currNum = 0;
                result *= stack.pop(); //sign
                result += stack.pop(); //cached result
            }
        }
        
        if(currNum != 0) result += currNum * sign; //add remaining
        
        return result;
    }
}