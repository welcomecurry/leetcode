class Solution {
    public int jump(int[] nums) {
        //init jumps, currentPos and farthestIndex
        //loop through nums till second last elemnt
        //farthest index is the max of farthestIndex and i + nums[i]
        //if i == currPos then increment jumps and set currPos to fartest index
        //return jumps
        
        int jumps = 0, currPos = 0, farthestIndex = 0;
        
        for(int i = 0; i < nums.length - 1; i++)
        {
            farthestIndex = Math.max(farthestIndex, i + nums[i]);
            
            if(i == currPos)
            {
                jumps++;
                currPos = farthestIndex;
            }
        }
        
        return jumps;
    }
}