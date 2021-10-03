class Solution {
    public int[][] generateMatrix(int n) {
        //init matrix of n * n
        //init pointers that will traverse the matrix, top, left, right, bottom
        //init val that will populate matrix
        //loop through while val <= n * n
            //loop through from left to right, increment top
            //loop through from top to bottom, decrement right
            //loop through from right to left, increment bottom
            //loop through from bottom to top, increment left
        //return matrix
        
        int[][] spiral = new int[n][n];
        int val = 1, top = 0, left = 0, right = n - 1, bottom = n - 1;
        
        while(val <= n * n)
        {
            for(int i = left; i <= right; i++) spiral[top][i] = val++;
            
            top++;
            
            for(int i = top; i <= bottom; i++) spiral[i][right] = val++;
            
            right--;
            
            for(int i = right; i >= left; i--) spiral[bottom][i] = val++;
            
            bottom--;
            
            for(int i = bottom; i >= top; i--) spiral[i][left] = val++;
            
            left++;
        }
        
        return spiral;
    }
}