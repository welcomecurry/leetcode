class Solution {
    public int numIslands(char[][] grid) {
        //dfs
        //init islands and set row and col
        //loop through matrix
        //if the current element is a 1
        //perform dfs and increment islands
        //return islands
        
        int islands = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void dfs(char[][] grid, int i, int j)
    {
        //base case if i or j is out of bounds or current element is not a 1 return
        //otherwise travel left right up and down
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
        {
            return;
        }
        
        grid[i][j] = '0';
        
        dfs(grid, i, j - 1); //left
        dfs(grid, i, j + 1); //right
        dfs(grid, i - 1, j); //up
        dfs(grid, i + 1, j); //down
    }
}