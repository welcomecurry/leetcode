class Solution {
    
    int paths = 0;
    
    public int uniquePathsIII(int[][] grid) {
        //dfs
        //loop through and count empty cells and mark start square
        
        int empty = 0, startX = -1, startY = -1;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    startX = i;
                    startY = j;
                }
                else if(grid[i][j] == 0)
                {
                    empty++;
                }
            }
        }
        
        dfs(grid, startX, startY, 0, empty + 1);
        
        return paths;
    }
    
    private void dfs(int[][] grid, int i, int j, int cellCount, int emptyCells)
    {
        //base check if we are in bounds and current cell has not been visted
        //if we are on the ending cell and our cellCount mathces emptyCell, increment paths
        //set current cell to visited
        //increment cellCount
        //backtrack on all directions
        //set cell back to unvisited
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) return;
        
        if(grid[i][j] == 2) //ending cell
        {
            if(cellCount == emptyCells) paths++;
            
            return;
        }
        
        grid[i][j] = -1; //mark visited
        cellCount++;
        
        dfs(grid, i - 1, j, cellCount, emptyCells); //left
        dfs(grid, i + 1, j, cellCount, emptyCells); //right
        dfs(grid, i, j - 1, cellCount, emptyCells); //up
        dfs(grid, i, j + 1, cellCount, emptyCells); //down
        
        grid[i][j] = 0; //unmark
    }
}