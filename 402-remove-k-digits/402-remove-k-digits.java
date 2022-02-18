class Solution {
    public String removeKdigits(String num, int k) {
        //base case if k == num return 0
        //init stack
        //loop through num
        //while stack size > 0 and k > 0 and peek > current char pop
        //otherwise push
        //if k > 0 pop off and decrement k for edge case like 1111
        //init stringbuilder
        //pop off stack and append
        //then remove any prepending zeros
        
        if(k == num.length()) return "0";
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < num.length(); i++)
        {
            char c = num.charAt(i);
            
            while(!stack.isEmpty() && k > 0 && stack.peek() > c)
            {
                stack.pop();
                k--;
            }
            
            stack.push(c);
        }
        
        while(k-- > 0) stack.pop(); //for edge case like 1111
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) sb.append(stack.pop());
        
        sb = sb.reverse();
        
        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        return sb.toString();
    }
}