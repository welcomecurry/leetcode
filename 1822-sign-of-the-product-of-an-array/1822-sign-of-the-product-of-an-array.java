class Solution {
    public int arraySign(int[] nums) {
        //if we encounter 0 return 0
        //keep prod init to 1
        //if num is zero return 0
        //if num is < 0 and prod < 0, set to 1
        //if num < 0 and prod > 0 set to -1
        //return prod at end
        
        int prod = 1;
        
        for(int i : nums)
        {
            if(i == 0) return 0;
            
            if(i < 0 && prod < 0) 
            {
                prod = 1;
            }
            else if(i < 0 && prod > 0)
            {
                prod = -1;
            }
        }
        
        return prod;
    }
}