class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //init dp array and slices
        //loop through from 2 to A.length
        //if [i - 1] - [i - 2] == [i] - [i-1], it is a arithmetic slice
        //dp[i] = 1 + dp[i - 1] and += slices at dp[i]
        //if we move forward and there was a slice before it, that means there will be a slice
        //in-between the new and previous, so add one since we have a new slice + previous
        
        int[] dp = new int[A.length];
        int slices = 0;
        
        for(int i = 2; i < A.length; i++)
        {
            if(A[i - 1] - A[i - 2] == A[i] - A[i - 1]) //is a slice
            {
                dp[i] = 1 + dp[i - 1];
                slices += dp[i];
            }
        }
        
        return slices;
    }
}