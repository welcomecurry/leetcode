class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //same as subarray equals k but in 2d
        //calculate prefix sums for each row
        //loop thorugh the matrix, start and end
        //init map and curr sub matrixsum
        //add curr prefix sum
        //if map contains key add it to count
        //increment count in map
        //return count
        
        int count = 0;
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        for(int start = 0; start < matrix[0].length; start++)
        {
            for(int end = start; end < matrix[0].length; end++)
            {
                //same as subarray equals k
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                
                int currSubMatrixSum = 0;
                
                for(int row = 0; row < matrix.length; row++)
                {
                    currSubMatrixSum += matrix[row][end] - (start > 0 ? matrix[row][start - 1] : 0);
                    count += map.getOrDefault(currSubMatrixSum - target, 0);
                    map.put(currSubMatrixSum, map.getOrDefault(currSubMatrixSum, 0) + 1);
                }
            }
        }
        
        return count;
    }
}