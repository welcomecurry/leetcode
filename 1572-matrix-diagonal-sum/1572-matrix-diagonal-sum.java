class Solution {
    public int diagonalSum(int[][] mat) {
        //to compute primary, if i == j add mat[i][j] to sum
        //to compute secondary if i + j == length - 1 add to sum
        //if the matrix is even just return sum since we did not count mid twice
        //otherise if the length is odd
        //we must find midpoint and subtract it from sum since we added it twice
        
        int sum = 0;
        
        //primary & secondary
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                if(i == j)
                {
                   sum += mat[i][j]; 
                }
                
                if(i + j == (mat.length - 1))
                {
                    sum += mat[i][j];
                }
            }
        }
        
        if(mat.length % 2 == 0)
        {
            return sum;
        }
        
        int mid = (mat.length-1) / 2;
        
        return sum - mat[mid][mid];
    }
}