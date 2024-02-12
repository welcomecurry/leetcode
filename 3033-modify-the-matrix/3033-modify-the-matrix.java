class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        //loop through each column
        //log the -1 coords
        //take max of col and set cords to max
        //return mat
        
        for(int i = 0; i < matrix[0].length; i++) {
            ArrayList<int[]> negOneCoordsList = new ArrayList<>();
            int max = 0;
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[j][i] == -1) {
                    negOneCoordsList.add(new int[] {j, i});
                }
                max = Math.max(max, matrix[j][i]);
            }
            if(negOneCoordsList.size() == 0) continue;
            
            for(int[] coords : negOneCoordsList) {
                matrix[coords[0]][coords[1]] = max;   
            }
        }
        
        return matrix;
    }
}