class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        final int h = nums1.length, w = nums2.length;
        
        int[][] dp = new int[h+1][w+1];
        
        for( int y = 0 ; y < h ; y++){
            for( int x = 0 ; x < w ; x++){
                
                if( nums1[y] == nums2[x] ){
                    dp[y+1][x+1] = dp[y][x] + 1;
                    
                }else{
                    dp[y+1][x+1] = Math.max( dp[y][x+1], dp[y+1][x]);
                }
            }
        }
        return dp[h][w];
    }
}