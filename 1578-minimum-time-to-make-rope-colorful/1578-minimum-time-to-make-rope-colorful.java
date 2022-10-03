class Solution {
    public int minCost(String s, int[] cost) {
        //create stack
        //loop through the string
        //if stack is not empty and stack.peek() == currentChar
            //deletions += min(cost[i], cost[i - 1])
            //pop off stack and push current char
        //otherwise push onto stack
        //return deletions
        
        Stack<Character> stack = new Stack<>();
        int deletionCost = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i))
            {
                deletionCost += Math.min(cost[i], cost[i - 1]);
                cost[i] = Math.max(cost[i], cost[i - 1]);
                stack.pop();
                stack.push(s.charAt(i));
            }
            else
            {
                stack.push(s.charAt(i));
            }
        }
        
        return deletionCost;
    }
}