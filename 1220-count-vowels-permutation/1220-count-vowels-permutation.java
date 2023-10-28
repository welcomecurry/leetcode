class Solution {
    public int countVowelPermutation(int n) {
        int MOD = 1000000007;
        int i, j;
        
        // Rows indicate 'n' and columns indicate the '5' vowels -> a, e, i, o , u
        int dp[][] = new int[n][5];
        
        // Note the following:
        // Words ending with e, u, i can append 'a' (Why? because read conditions 3, 4 & 6.
        // From condition 3, 'e' may be followed by 'a' or in other words, the words ending with 'e' can append 'a'. Similarly, we can see that words ending with 'i' and 'u' can append 'a' from conditions 4 & 6 respectively.)
        // Similarly, below are derived.
        // Words ending with a, i can append 'e'
        // Words ending with e, o can append 'i'
        // Words ending with i can append 'o'
        // Words ending with o, i can append 'u'
        
        // Rows are 0-indexed, row 0 means n=1, row 1 means n=2 ... and so on... row n-1 means 'n'.
        for(j=0;j<5;j++){
            // For n=1, we can have only 1 word ending with that particular vowel.
            // The answer would be sum of all columns.
            dp[0][j] = 1;
        }
        
        for(i=1;i<n;i++){
            for(j=0;j<5;j++){
                // For vowel 'a' add columns for 'e', 'i' and 'u' i.e. 1, 2 & 4 of the previous row.
                if(j==0){
                    dp[i][j] = ((dp[i-1][1] + dp[i-1][2])%MOD + dp[i-1][4])%MOD;
                }
                else if(j==1){
                    // For vowel 'e' add columns for 'a' and 'i', i.e. 0 & 2.
                    dp[i][j] = (dp[i-1][0] + dp[i-1][2])%MOD;
                }
                else if(j==2){
                    // For vowel 'i' add columns for 'e' and 'o', i.e. 1 & 3.
                    dp[i][j] = (dp[i-1][1] + dp[i-1][3])%MOD;
                }
                else if(j==3){
                    // For vowel 'o' add columns for 'i' i.e. 2.
                    dp[i][j] = (dp[i-1][2])%MOD;
                }
                else{
                    // For vowel 'u' add columns for 'i' and 'o' i.e. 2 and 3.
                    dp[i][j] = (dp[i-1][2] + dp[i-1][3])%MOD;
                }
            }
        }
        
        // Add the last row's all columns to get the final answer.
        int ans = 0;
        for(j=0;j<5;j++){
            ans = (ans%MOD + dp[n-1][j]%MOD)%MOD;
        }
        
        return ans;
    }
}