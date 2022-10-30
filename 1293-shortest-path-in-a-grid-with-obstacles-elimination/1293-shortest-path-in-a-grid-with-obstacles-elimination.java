class Solution {
    public int shortestPath(int[][] grid, int k) {
        //bfs
        //init visited array and fill with -1
        //init queue and add 0,0,k
        //loop while queue is not empty
        //loop through current level
        //grab current cell
        //if cell is out of bounds or obstacle <= current visited position, continue
        //otherwise mark as visited
        //check we are on last cell if we are return steps
        //loop through all directions and add to queue
        //increment steps
        //if we make it through the bfs, there is no walk so return -1
        
        int[][] visited = new int[grid.length][grid[0].length];
        for(int[] row : visited) Arrays.fill(row, -1);
        
        int minSteps = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, k});
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            while(size-- > 0)
            {
                int[] curr = queue.poll();
                int i = curr[0], j = curr[1], obs = curr[2];
                
                //check in bounds
                if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) continue;
                
                //check whether the coordinate has been visited with same number or less obstacles
                if(obs <= visited[i][j]) continue;
                
                visited[i][j] = obs;
                
                if(i == grid.length - 1 && j == grid[0].length - 1) return minSteps;
                
                if(grid[i][j] == 0 || --obs >= 0)
                {
                    queue.add(new int[] {i, j - 1, obs}); //left
                    queue.add(new int[] {i, j + 1, obs}); //right
                    queue.add(new int[] {i - 1, j, obs}); //up
                    queue.add(new int[] {i + 1, j, obs}); //down
                }
            }
            minSteps++;
        }
        
        return -1;
    }
}