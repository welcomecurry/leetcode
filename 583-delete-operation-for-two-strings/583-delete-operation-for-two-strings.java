class Solution {
    public int minDistance(String word1, String word2) {
        //find longest common subsequence
        //init dp array of lengths of words + 1 since we are counting empty string
        //loop through to word1 length
        //loop through to word2 length
        //if i or j is 0 continue
        //if chars at i - 1 and j - 1 match, dp[i][j] = 1 + diagonal element
        //otherwise if they dont match dp[i][j] = max of elements left and above
        //return the sum of lengths of both strings - 2 * longest common subsequence
        //we are removing from both strings so we add them
        //since we need to remove characters from both string it is 2 * LCS
        //the difference are the uncommon characters that we need to delete
        
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for(int i = 0; i <= word1.length(); i++)
        {
            for(int j = 0; j <= word2.length(); j++)
            {
                if(i == 0 || j == 0) continue;
                
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) //characters match
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; //1 + diagonal element 
                }
                else //characters dont match
                {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]); //max of elements left and above
                }
            }
        }
        
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}