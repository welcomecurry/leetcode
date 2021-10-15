class Solution {
    public int numDecodings(String s) {
        
        if(s.charAt(0) == '0') return 0;
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; //empty string can be decoded in 1 way
        dp[1] = 1; //1 char can be decoded in 1 way
        
        for(int i = 2; i <= s.length(); i++)
        {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            
            if(first >= 1 && first <= 9)
            {
                dp[i] += dp[i - 1];
            }
            
            if(second >= 10 && second <= 26)
            {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}