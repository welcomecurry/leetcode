class Solution {
    public int cherryPickup(int[][] grid) {
        //dynamic programming dfs
        //init 3d dp array
        //perform dfs on the grid
        int row = grid.length, col = grid[0].length;
        
        Integer[][][] dp = new Integer[row][col][col];
        return dfs(grid, row, col, 0, 0, col - 1, dp);
    }
    
    private int dfs(int[][] grid, int row, int col, int currRow, int robot1, int robot2, Integer[][][] dp)
    {
        //base check, check we are in bounds
        //base check, check we have visited cell
        //loop through all directions and take max of current cell
        //if we are on the same cell only take cherry once
        //otherwise add both cells
        //then set dp element to currMaxCherry + prevMaxCherry
        //return currRow, robot1, robot2
        
        if(currRow < 0 || currRow >= row || robot1 < 0 || robot1 >= col || robot2 < 0 || robot2 >= col)
        {
            return 0;
        }
        
        if(dp[currRow][robot1][robot2] != null) return dp[currRow][robot1][robot2];
        
        int maxCherries = 0;
        
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                maxCherries = Math.max(maxCherries, dfs(grid, row, col, currRow + 1, robot1 + i, robot2 + j, dp));
            }
        }
        
        int currCherry = robot1 == robot2 ? grid[currRow][robot1] : grid[currRow][robot1] + grid[currRow][robot2];
        
        dp[currRow][robot1][robot2] = currCherry + maxCherries;
        return dp[currRow][robot1][robot2];
    }
}