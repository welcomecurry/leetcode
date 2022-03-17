class Solution {
    public int scoreOfParentheses(String S) {
        //there are two cases
        //addition when you have braces next to each other
        //multiplication when you have nested braces
        //init a stack of ints
        //init score
        //loop through each char in S
        //if the char is ( then push score onto stack and reset score
        //otherwise if char is ), score = stack.pop() (current score) + max of score * 2, 1
        //return score
        
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        
        for(char c : S.toCharArray())
        {
            if(c == '(')
            {
                stack.push(score);
                score = 0;
            }
            else
            {                                 //nested or just pair
                score = stack.pop() + Math.max(score * 2, 1);
            }
        }
        return score;
    }
}