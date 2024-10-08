class Solution {
    public int minSwaps(String s) {
        //initiatilize stack
        //if there is an open bracket add to stack
        //otherwise if the stack is not empty pop else increment closedBrackets
        //return (closedBrackets + 1 / 2) - can only swap half of the brackets in one swap
        
        Stack<Character> stack = new Stack<>();
        int closedBrackets = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '[') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) { //coresponding closing bracket
                    stack.pop();
                } else {
                    closedBrackets++;
                }
            }
        }
        
        return (closedBrackets + 1) / 2;
    }
}