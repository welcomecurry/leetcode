class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    long[][] memo;
    long mod = 1000000007; 
    
    public int countPaths(int[][] grid) {
        //standard dfs with memo
        long count = 0;
        memo = new long[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                count = (count + dfs(grid, i, j)) % mod;
            }
        }
        
        return (int) (count % mod);
    }
    
    private long dfs(int[][] grid, int i, int j) {
        //if visited return visited element
        //otherwise loop through all directions, if out of bounds or visited continue
        //otherwise ans += dfs % mod, set current element to ans and return ans
        
        if(memo[i][j] != 0) return memo[i][j];
        
        long ans = 1;
        
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] <= grid[i][j]) {
                continue;
            }
            
            ans += (dfs(grid, x, y) % mod);
        }
        
        memo[i][j] = ans;
        
        return ans;
    }
}