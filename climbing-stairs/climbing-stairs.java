class Solution {
    public int climbStairs(int n) {
        //dynamic programming
        //init a dp array of size n + 1
        //set the first element to 1, since there is 1 way to climb 0 stairs
        //set the second element to 1, since there is 1 way to climb 1 stair
        //loop through from 2 to n
        //dp[i] = dp[i - 1] + dp[i - 2]
        //return dp[n]
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}