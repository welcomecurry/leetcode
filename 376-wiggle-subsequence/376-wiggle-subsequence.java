class Solution {
    public int wiggleMaxLength(int[] nums) {
        //determine if we are going up or down
        //init two variables up and down to 1
        //loop through nums
        //if we are going uphill, up = down + 1
        //otherwise down = up + 1
        //return the max of up and down
        
        if(nums.length < 2) return nums.length;
        
        int up = 1, down = 1;
        
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] < nums[i + 1]) //uphill
            {
                up = down + 1;
            }
            else if(nums[i + 1] < nums[i]) //downhill
            {
                down = up + 1; 
            }
        }
        
        return Math.max(up, down);
    }
}