class Solution {
    public int islandPerimeter(int[][] grid) {
        //init perimeter
        //loop through grid
        //if the current element is 1 / is land
        //assume that is is a single land and increment 4 to perimeter since
        //a square has a perimeter of 4
        //now we want to check to the, left, right, above and below currElement
        //to see if we have another square, if its touching another square it 
        //loses a side so decrement perimeter by 1
        //count perimeter for each square and return perimeter
        
        int p = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    p += 4;
                    
                    if(j > 0 && grid[i][j - 1] == 1) p--;
                    
                    if(j < grid[0].length - 1 && grid[i][j + 1] == 1) p--;
                    
                    if(i > 0 && grid[i - 1][j] == 1) p--;
                    
                    if(i < grid.length - 1 && grid[i + 1][j] == 1) p--;
                }
            }
        }
        
        return p;
    }
}