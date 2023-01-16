class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        //for each query loop and increment 
        
        int[][] matrix = new int[n][n];
        
        for(int[] query : queries) {
            int r1 = query[0], r2 = query[2];
            int c1 = query[1], c2 = query[3];
            
            for(int i = r1; i <= r2; i++) {
                for(int j = c1; j <= c2; j++) {
                    matrix[i][j] = matrix[i][j] + 1;
                }
            }
        }
        
        return matrix;
    }
}