class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //int row and col, row starting at 0 and col starting at last element
        //loop through while row and col are in bounds
        //if matrix[row][col] < target, move down a row
        //otherwise if it is greater, move column to left
        //we will them converge to target
        //if we make it through loop we found no target so return false
        
        int row = 0, col = matrix[0].length - 1;
        
        while(row < matrix.length && col >= 0)
        {
            if(matrix[row][col] == target)
            {
                return true;
            }
            else if(matrix[row][col] < target)
            {
                row++;
            }
            else
            {
                col--;
            }
        }
        
        return false;
    }
}