class Solution {
    public int orangesRotting(int[][] grid) {
        //classic bfs
        //init queue
        //initally loop through grid and count all fresh oranges so we can mark them
        //for every orange that is rotton add its row and col to the queue
        //otherwise increment freshOranges
        //base check if we have no fresh to turn rotton return 0
        //init minutes
        //init directions to travel, left, right, up and down
        //loop through queue
        //while size-- > 0
        //poll off current orange
        //loop through all directions
        //if we are in bounds and the current element is fresh add to queue
        //and decrement the amount of fresh oranges and set to rotton
        //increment minutes at end of loop
        //if we are left we no fresh oranges return minutes otherwise return -1
        
        Queue<int[]> queue = new LinkedList<>();
        
        int freshOranges = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 2)
                {
                    queue.add(new int[] {i , j});
                }
                else if(grid[i][j] == 1)
                {
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0) return 0;
        
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int minutes = 0;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                int[] currOrange = queue.poll();
                
                for(int[] dir : directions)
                {
                    int currRow = currOrange[0] + dir[0];
                    int currCol = currOrange[1] + dir[1];
                    
                    if(currRow >= 0 && currCol >= 0 && currRow < grid.length && currCol < grid[0].length && grid[currRow][currCol] == 1) //if we find fresh orange
                    {
                        grid[currRow][currCol] = 2; //set to rotton
                        queue.add(new int[] {currRow, currCol}); //add to queue
                        freshOranges--; //decrement fresh oranges
                    }
                }
            }
            minutes++;
        }
        
        return freshOranges != 0 ? -1 : minutes - 1;
    }
}