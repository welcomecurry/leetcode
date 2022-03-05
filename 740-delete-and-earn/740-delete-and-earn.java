class Solution {
    public int deleteAndEarn(int[] nums) {
        //dynamic programming
        //similar to house robber
        //init array to count occurences 
        //take or skip
        
        int[] vals = new int[10001];
        
        for(int num : nums) vals[num] += num;
        
        int take = 0, skip = 0;
        for(int i = 0; i < vals.length; i++)
        {
            int takei = skip + vals[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        
        return Math.max(take, skip);
    }
}