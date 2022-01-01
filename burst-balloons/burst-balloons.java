class Solution {
    public int maxCoins(int[] nums) {
        //dynamic programming
        //create new array that adds 1's on the start and end
        //init memo array
        //return helper from 0 to nums.length - 1
        
        int[] arr = new int[nums.length + 2];
        arr[0] = arr[arr.length - 1] = 1;
        for(int i = 0; i < nums.length; i++)
        {
            arr[i + 1] = nums[i];
        }
        
        int[][] memo = new int[arr.length][arr.length];

        return getCoins(arr, memo, 0, arr.length - 1);
    }
    
    
    private int getCoins(int[] arr, int[][] memo, int l, int r)
    {
        //init max
        //we are using memo to store subproblems so we don't need to repeat subprobs to avoid TLE
        //base cases, if we reach a repeated subproblem return 
        //loop from left + 1 to right
        //calculate the score which is arr[l] * arr[i] * arr[r]
        //take max and recurse on left and right
        //return max
        
        if (l + 1 == r) return 0;
        if (memo[l][r] > 0) return memo[l][r];
        
        int maxCoins = 0;

        for(int i = l + 1; i < r; i++)
        {
            int score = arr[l] * arr[i] * arr[r];
            maxCoins = Math.max(maxCoins, score + getCoins(arr, memo, l, i) + getCoins(arr, memo, i, r));
        }
                    
        memo[l][r] = maxCoins;
        
        return maxCoins;
    }
     
}