class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);                                    // Step 1
        
        int score = 0, ans = 0;
        int lo = 0, hi = tokens.length-1;
        
        if( hi < 0 || tokens[0] > power) return 0;
        
        while(lo <= hi && score >= 0) {
            if(power >= tokens[lo]) {                           // Step 2
                power -= tokens[lo++];
                score++;
                ans = Math.max(ans, score);
            }
            else {                                              // Step 3
               power += tokens[hi--];
               score--; 
           }
        }
        return ans;                                             // Step 4
    }
}