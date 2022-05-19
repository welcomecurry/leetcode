class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        //init result and m and n and cache to check visited
        //loop through matrix
        //call dfs on each cell
        //return max
        int longestPath = 0, m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                longestPath = Math.max(longestPath, dfs(matrix, cache, m, n, i, j));
            }
        }
        
        return longestPath;
    }
    
    private int dfs(int[][] matrix, int[][] cache, int row, int col, int r, int c)
    {
        //base case, if not in bounds return 0
        //base case if current element has been cached, return cached element
        //go thorugh all direction, left, right, up and down
        //if going in that direction, we are in bounds and element in that direction > curr element
        //recurse if valid
    	//Finally, take the biggest possible answer and add 1 as this current element must be counted
		//Store that result in the cache
        
        if(r >= row || r < 0 || c >= col || c < 0)
        {
            return 0;
        }
        
        if(cache[r][c] > 0)
        {
            return cache[r][c];
        }
        
        int currPath = 0;
        
        if(r - 1 >= 0 && matrix[r - 1][c] > matrix[r][c]) //up
        {
            currPath = Math.max(currPath, dfs(matrix, cache, row, col, r - 1, c));
        }
        
        if(r + 1 < row && matrix[r + 1][c] > matrix[r][c]) //down
        {
            currPath = Math.max(currPath, dfs(matrix, cache, row, col, r + 1, c));
        }
        
        if(c - 1 >= 0 && matrix[r][c - 1] > matrix[r][c]) //left
        {
            currPath = Math.max(currPath, dfs(matrix, cache, row, col, r, c - 1));
        }
        
        if(c + 1 < col && matrix[r][c + 1] > matrix[r][c]) //right
        {
            currPath = Math.max(currPath, dfs(matrix, cache, row, col, r, c + 1));
        }
        
        cache[r][c] = currPath + 1; //store path in cache
        return 1 + currPath;
    }
}