class Solution {
    public int minPathSum(int[][] grid) {
        //init row and col vars from grid
        //init dp array
        //fill first column with the path sums
        //fill first row with the path sums
        //we can only travel to the right and down
        //loop from entry (1,1) and add the current grid position to the minimum of
        //the element to the left and above it, aka determning to go right or down
        //once we populate dp, the minPathSum will be the last element
        
        //init row, col and dp
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        
        //set first element in dp and populate first column
        dp[0][0] = grid[0][0];
        
        //the first col is the path sum from top to bottom
        for(int i = 1; i < row; i++)
        {
            //current element is the sum of element above and curr element in grid
            dp[i][0] = dp[i - 1][0] + grid[i][0]; 
        }
        
        //populate first row with path sum from left to right
        for(int i = 1; i < col; i++)
        {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        
        //start from entry (1,1), add the current element in grid to the minimum of
        //the elements to the left and above
        
        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col; j++)
            {                                   //< above >    < to the left >
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        
        //return last element
        return dp[row - 1][col - 1];
    }
}