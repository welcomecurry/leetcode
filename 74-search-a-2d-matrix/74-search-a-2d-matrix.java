class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //brute force 
        //loop through the matrix
        //if we find match return true
        //otherwise false
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == target)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}