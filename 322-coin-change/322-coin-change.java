class Solution {
    public int coinChange(int[] coins, int amount) {
        //bottom up dp
        //we want to find the min coins to make change from 0 to amount
        //use subproblems to solve current problem
        //init dp array to amount + 1 and set all elements to amount + 1
        //set first element to 0, since there are 0 ways to make change on amount 0
        //loop from 1 to amount
        //loop through each coin we have
        //if the current coin <= i *(current amount), it is valid
        //dp[i] = Math.min(dp[i], 1 + dp[i - currentCoin]);
        //we are adding one since we are adding a coin for new amount
        //we use previously computed mins to calculate current min for each coin
        //return dp of amount, if it is amount + 1, it was never changed so return
        //-1 otheriwse dp[amount] holds the answer so return it
        
        //init dp, fill and set first element to 0 since zero ways to make change on amount 0
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        //loop from 1 to amount
        for(int i = 1; i <= amount; i++)
        {
            //loop through each coin and determine min at current amount, aka i
            for(int coin : coins)
            {
                //if the current coin is valid for current amount
                if(coin <= i)
                {
                    //adding one since we are adding one coin for new amount
                    //another coin + (dp[i - coin], which is previous sub problem)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        
        //if amount cannot be made with given coins, return -1, otherwise return
        //min coins for amount
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}