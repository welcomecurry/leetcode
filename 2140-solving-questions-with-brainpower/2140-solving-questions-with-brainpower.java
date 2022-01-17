class Solution {
    public long mostPoints(int[][] questions) {
        //dfs
        //dp memoization
        long[] dp = new long[questions.length];
        return dfs(questions, dp, 0);
    }
    
    private long dfs(int[][] questions, long[] dp, int index)
    {
        //base case if we are out of bounds return 0
        //base case if we have visited the current element return it from dp array
        //otherwise we have two options
        //1. Take points i and jump the next brainpower i indexes
        //2. Skip the current index(do not collect points i) and move to the next index
        //take max of both options and return dp[index]
        
        if(index >= dp.length) return 0;
        
        if(dp[index] > 0) return dp[index];
        
        long curr = questions[index][0] + dfs(questions, dp, index + questions[index][1] + 1);
        long next = dfs(questions, dp, index + 1);
        
        dp[index] = Math.max(curr, next);
        
        return dp[index];
    }
}