class Solution {
    public int uniquePaths(int m, int n) {
        //dynamic programming!
        //since we can only go right and down we need to check above and left
        //so we set all boxs in row and col 0 to 1 since there is only 1 way to get there
        //then, to calculate the paths we need to sum elements to the left and above us
        //keep summing until we reach target, bottom right
        //dp of target will be all the unique paths to that point
        //so return dp[m - 1][n - 1]
        
        int[][] paths = new int[m][n];
        
        for(int i = 0; i < paths.length; i++)
        {
            paths[i][0] = 1;
        }
        
        for(int i = 0; i < paths[0].length; i++)
        {
            paths[0][i] = 1;
        }
        
        for(int i = 1; i < paths.length; i++)
        {
            for(int j = 1; j < paths[0].length; j++)
            {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        
        return paths[m - 1][n - 1];
    }
}