class Solution {
    public int minAddToMakeValid(String S) {
        //Solution 1
        //Create stack
        //loop through characters
        //if stack is not empty and char == ')' and peek is')'
        //pop off stack since that is a valid parenthesis pair
        //otherwise push onto stack
        //return stack size
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : S.toCharArray()) {
            if(!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        
        return stack.size();
        
        //Solution 2
        //while S.contains("()")
        //s = s.replace("()", "")
        //then simply return string size
    }
}