class Solution {
    public boolean checkPossibility(int[] nums) {
        //we are checking if array is increasing
        //loop thorugh array
        //if we hit condition, we need to make a choice
        //if element at i - 2 <= element at i, set i - 1 to i
        
        int modified = 0;
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i - 1] > nums[i])
            {
                modified++;
                if(modified > 1) return false; //we cant modify more than one
                
                //determine how we are going to modify current element
                if(i < 2 || nums[i - 2] <= nums[i])
                {
                    nums[i - 1] = nums[i];
                }
                else
                {
                    nums[i] = nums[i - 1];
                }
            }
            
        }
        
        return true;
    }
}