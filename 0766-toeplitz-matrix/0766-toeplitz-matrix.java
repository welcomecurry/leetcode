class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //wtf is this shit
                
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i + 1 < matrix.length && j + 1 < matrix[0].length && matrix[i][j] != matrix[i + 1][j + 1])                 {
                    return false;
                }
            }
        }
        
        return true;
    }
}
