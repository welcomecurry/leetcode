class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //dynamic programming
        //init 2d dp array of string lengths + 1 since we are counting a "" (empty string initially)
        //loop through 1 to text1 length
        //loop through 1 to text2 length
        //starting at 1 since we are not counting empty strings
        //if characters at i - 1 and j - 1 match, dp[i][j] = 1 + dp[i - 1][j - 1]
        //^ 1 + the diagonal element
        //otherwise if character dont match dp[i][j] = max of element to the left and above
        //last element in dp array will be ans so return that
        
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for(int i = 1; i <= text1.length(); i++)
        {
            for(int j = 1; j <= text2.length(); j++)
            {
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
}