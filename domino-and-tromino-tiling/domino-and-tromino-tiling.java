class Solution {
    public int numTilings(int n) {
        //dynamic programming
        //init array and init first 3 elements
        //loop starting at 3, dp[i] = prev element * 2 + dp[i - 3] mod 10^9+7
        //return dp[n - 1]
        
        long[] dp = new long[n + 3];
        dp[0] = 1; dp[1] = 2; dp[2] = 5;
        
        for(int i = 3; i < n; i++)
        {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
        }
        
        return (int) dp[n - 1];
    }
}