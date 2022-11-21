class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        //bfs
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;
        
        while(!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            
            while(size-- > 0) {
                int[] curr = queue.poll();
                
                for(int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    //out of bounds
                    if(x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == '+') {
                        continue;
                    }
                    
                    //found exit
                    if(x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1) {
                        return steps;
                    }
                    
                    maze[x][y] = '+'; //mark as visited
                    queue.add(new int[] {x, y}); //add the next step
                }                
            }            
        }
        
        return -1;
    }
}