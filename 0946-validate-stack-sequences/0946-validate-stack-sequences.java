class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //init stack
        //init pointer for popped array
        //loop through pushed
        //push onto stack
        //while peek == popped[j] and in bounds, pop off stack and increment j
        //return if j == popped.length
        
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        
        for(int p : pushed)
        {
            stack.push(p);
            while(!stack.isEmpty() && j < popped.length && stack.peek() == popped[j])
            {
                stack.pop();
                j++;
            }
        }
        
        return j == popped.length;
    }
}