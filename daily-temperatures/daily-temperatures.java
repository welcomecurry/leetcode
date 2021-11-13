class Solution {
    public int[] dailyTemperatures(int[] T) {
        //create stack and output array
        //loop through starting from the end
        //while stack is not empty and T[i] >= T[stack.peek()]
            //pop off stack
        //if stack is empty add 0 to result
        //otherwise add peek - i to result
        //push indice onto stack
        //return output
        
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[T.length];
        
        for(int i = T.length - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()])
            {
                stack.pop();
            }
            
            if(stack.isEmpty())
            {
                output[i] = 0;
            }
            else
            {
                output[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        
        return output;
    }
}