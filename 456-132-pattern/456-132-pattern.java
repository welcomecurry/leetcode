class Solution {
    public boolean find132pattern(int[] nums) {
        //loop through the array and keep array of min values
        //create stack
        //loop through the array again starting from the end
        //if nums[i] > min[i]
            //while peek <= min pop off
            //if peek < current element
                //return true
            //otherwise push current element onto stack
        //if we get through the loop => no matches so return false
        
        int[] minVals = new int[nums.length];
        minVals[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            minVals[i] = Math.min(minVals[i - 1], nums[i]);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(nums[i] > minVals[i])
            {
                while(!stack.isEmpty() && stack.peek() <= minVals[i])
                {
                    stack.pop();
                }
                
                if(!stack.isEmpty() && stack.peek() < nums[i])
                {
                    return true;
                }
                else
                {
                    stack.push(nums[i]);
                }
            }
        }
        
        return false;
    }
}