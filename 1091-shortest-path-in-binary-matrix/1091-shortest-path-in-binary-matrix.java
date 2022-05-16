class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //bfs
        //base case if the first element is a 1 return -1 since we cant travel any direction
        //init a queue that hold array of x,y,numOfSteps
        //add first cell to queue and mark as visited
        //init directions we can travel as int array
        //there are 8 directions we can go, left,right,up,down and digonally in respective directions
        //loop through queue
        //loop through size
        //poll current cell
        //if we are at last cell return numberOfSteps
        //loop through all directions we can travel at current cell
        //if it is in bounds and equals 0, add to queue and mark cell as visited
        //if we make it through bfs there is no path so return -1
        
        if(grid[0][0] == 1) return -1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        
        grid[0][0] = 1;
        
                        //     top    bottom    left    right   <            diagonals            >
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                int[] currCell = queue.poll();
                
                if(currCell[0] == grid.length - 1 && currCell[1] == grid[0].length - 1)
                {
                    return currCell[2];
                }
                
                for(int[] dir : directions)
                {
                    int currRow = currCell[0] + dir[0];
                    int currCol = currCell[1] + dir[1];
                    
                    if(currRow >= 0 && currCol >= 0 && currRow < grid.length && currCol < grid[0].length && grid[currRow][currCol] == 0)
                    {
                        queue.add(new int[] {currRow, currCol, currCell[2] + 1});
                        grid[currRow][currCol] = 1;
                    }
                }
            }
        }
        
        return -1;
    }
}