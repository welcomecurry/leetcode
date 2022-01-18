class Solution {
    public int numEnclaves(int[][] grid) {
        //dfs
        //if we are on a border element and is a land cell perform dfs and set cells adjacent to 0
        //loop through matrix again and count 1's (enclaves)
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && (grid[i][j] == 1))
                {
                    dfs(grid, i, j);
                }
            }
        }
        
        int enclaves = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1) enclaves++;
            }
        }
        
        return enclaves;
    }
    
    private void dfs(int[][] grid, int i, int j)
    {
        //base check if we are in bounds and current element is a 1
        //set current element as visited
        //move in all directions
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        
        grid[i][j] = 0;
        
        dfs(grid, i, j - 1); //left
        dfs(grid, i, j + 1); //right
        dfs(grid, i - 1, j); //up
        dfs(grid, i + 1, j); //down
    }
}