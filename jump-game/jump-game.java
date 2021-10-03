class Solution {
    public boolean canJump(int[] nums) {
                //init farthest index
        //loop through till last element
        //farthest index = max of farthest index and i + nums[i]
        //if i == farthest, break since we can't go further
        //return farthestIndex >= nums.length - 1
        
        int farthestIndex = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            farthestIndex = Math.max(farthestIndex, i + nums[i]);
            
            if(i == farthestIndex) break;
        }
        
        return farthestIndex >= nums.length - 1;
    }
}