class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        
        for(int[] arr : dp) Arrays.fill(arr, Integer.MAX_VALUE);
        
        dp[dungeon.length - 1][dungeon[0].length] = 1;
        dp[dungeon.length][dungeon[0].length - 1] = 1;
        
        for(int i = dungeon.length - 1; i >= 0; i--)
        {
            for(int j = dungeon[0].length - 1; j >= 0; j--)
            {
                int minHP = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = minHP <= 0 ? 1 : minHP;
            }
        }
        
        return dp[0][0];
    }
}