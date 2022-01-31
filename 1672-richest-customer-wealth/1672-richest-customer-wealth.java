class Solution {
    public int maximumWealth(int[][] accounts) {
        //take max of every row
        int max = Integer.MIN_VALUE;
        
        for(int[] account : accounts)
        {
            max = Math.max(max, getCurrWealth(account));
        }
        
        return max;
    }
    
    private int getCurrWealth(int[] account)
    {
        int sum = 0;
        
        for(int i : account) sum += i;
        
        return sum;
    }
}