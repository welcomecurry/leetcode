class Solution {
    public int combinationSum4(int[] nums, int target) {
        //bottom up dp
        //similar approach as coin change, compute number of possible combos from 0 to target
        //dp[target] will contain the anwser
        //init dp array to size target + 1, set first element to 1, since one way to compute 0
        //loop starting at 1 to target
        //then loop through each num in nums
        //if i (temp target) - currentNum >= 0, dp[i] += dp[i - num]
        //return dp[target]
        
        int[] dp = new int[target + 1];
        dp[0] = 1; //one way to find target 0
        
        for(int currTarget = 1; currTarget <= target; currTarget++)
        {
            for(int currNum : nums)
            {
                if(currTarget - currNum >= 0)
                {
                    dp[currTarget] += dp[currTarget - currNum]; //add previous subproblems
                }
            }
        }
        
        return dp[target];
    }
}