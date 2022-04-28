class Solution {
    int[][] directions = new int[][]{ {0,1},{0,-1},{1,0},{-1,0} };
    
    public int minimumEffortPath(int[][] heights) {
        //binary search dfs
        //If there is a path from source vertex to destination vertex under cost c, 
        //then there must be a path under cost c + 1 and similarly, under c + 2 and so on. 
        //So basically we can do a binary search to find the minimum cost for which we can go 
        //from source vertex to destination vertex.
        //set left to 0, right to 10^6
        //loop while left < right
        //get mid
        //if dfs returns true on given mid, set right to mid
        //otherwise set left to mid + 1
        //return left
        
        int left = 0, right = 1000000;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            
            if(dfs(heights, 0, 0, new boolean[heights.length][heights[0].length], mid))
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean dfs(int[][] heights, int i, int j, boolean[][] visited, int limit)
    {
        //base case
        //if we reach the last cell return true
        //loop through directions
        //if any direction is out of bounds or we have visited cell, continue
        //otherwsie if the abs if current and new coordinates <= limit
        //set visited at curr pos to true
        //recurse on new direction and return true 
        //if we perform dfs and it does not find a path below limit return false
        
        if(i == heights.length - 1 && j == heights[0].length - 1) return true;
        
        for(int[] dir : directions)
        {
            int x = i + dir[0], y = j + dir[1];
            
            if(x < 0 || y < 0 || x >= heights.length || y >= heights[0].length || visited[x][y])
            {
                continue;
            }
            
            if(Math.abs(heights[x][y] - heights[i][j]) <= limit)
            {
                visited[x][y] = true;
                
                if(dfs(heights, x, y, visited, limit)) return true;
            }
        }
        
        return false;

    }
}