class Solution {
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        //classic dfs
        //init output
        //init boolean arrays for pacific and atlantic to mark valid coordinates
        //call dfs  top and bottom and left and right
        //after dfs loop through pacific and atlantic and if both cells are true add to output
        //return output
        
        List<List<Integer>> output = new ArrayList<>();
        m = matrix.length;
        if(m == 0) return output;
        n = matrix[0].length;
                    
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for(int col = 0; col < n; col++) //top and bottom
        {
            dfs(matrix, 0, col, matrix[0][col], pacific);
            dfs(matrix, m - 1, col, matrix[m - 1][col], atlantic);
        }
        
        for(int row = 0; row < m; row++) //left and right
        {
            dfs(matrix, row, 0, matrix[row][0], pacific);
            dfs(matrix, row, n - 1, matrix[row][n - 1], atlantic);
        }
        
        for(int row = 0; row < m; row++)
        {
            for(int col = 0; col < n; col++)
            {
                if(pacific[row][col] && atlantic[row][col])
                {
                    List<Integer> currCoordinate = new ArrayList<>();
                    currCoordinate.add(row);
                    currCoordinate.add(col);
                    
                    output.add(currCoordinate);
                }
            }
        }
        
        return output;
    }
    
    private void dfs(int[][] matrix, int row, int col, int height, boolean[][] ocean)
    {
        //base case, if dfs is not in bounds or current element < height or currElement is true, ret
        //otherwise set current ocean element to true and recurse on all directions
        
        if(row < 0 || col < 0 || row > m - 1 || col > n - 1 || matrix[row][col] < height || ocean[row][col])
        {
            return;
        }
        else
        {
            ocean[row][col] = true;
            dfs(matrix, row, col - 1, matrix[row][col], ocean); //left
            dfs(matrix, row, col + 1, matrix[row][col], ocean); //right
            dfs(matrix, row - 1, col, matrix[row][col], ocean); //up
            dfs(matrix, row + 1, col, matrix[row][col], ocean); //down

        }
    }
}