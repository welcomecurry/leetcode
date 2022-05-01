class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        //dfs
        //make matrix and set walls, 2
        //loop through guards set to 1, and set guard views to -1
        //count unguarded cells, 0
        
        int unguarded = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        char[][] mat = new char[m][n];
        
        for(int[] wall : walls)
        {
            mat[wall[0]][wall[1]] = 'W';
        }
        
        for(int[] guard : guards)
        {
            mat[guard[0]][guard[1]] = 'G';
        }
        
        for(int[] guard : guards)
        {
            for(int[] dir : directions)
            {
                int x = guard[0] + dir[0];
                int y = guard[1] + dir[1];
                
                while(x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && mat[x][y] != 'W' && mat[x][y] != 'G')
                {
                    //mark as visited
                    mat[x][y] = 'X';
                    //move in curr direction
                    x += dir[0]; 
                    y += dir[1];
                }
            }
        }
        
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                if(mat[i][j] != 'W' && mat[i][j] != 'G' && mat[i][j] != 'X') unguarded++;
            }
        }
        
        return unguarded;
    }
}