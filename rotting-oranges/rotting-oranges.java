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
        
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 2)
                {
                    queue.add(new int[] {i, j});
                }
                else if(grid[i][j] == 1)
                {
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0) return 0;
        
        int minutes = 0;    // left   right   up     down
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                int[] currOrange = queue.poll();
                
                for(int[] dir : directions)
                {
                    int newX = currOrange[0] + dir[0];
                    int newY = currOrange[1] + dir[1];
                    
                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1)
                    {
                        grid[newX][newY] = 2;
                        queue.add(new int[] { newX, newY });
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }
        
        return freshOranges != 0 ? -1 : minutes - 1;
    }
}