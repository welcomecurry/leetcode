class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        //similar to pascals triangle
        double[][] tower = new double[query_row + 1][query_glass + 2];
        tower[0][0] = poured;
        
        for(int i = 0; i < query_row; i++)
        {
            for(int j = 0; j <= query_glass; j++)
            {
                double rest = Math.max(tower[i][j] - 1.0, 0);
                tower[i + 1][j] += rest / 2.0;
                tower[i + 1][j + 1] += rest / 2.0;
            }
        }
        
        return Math.min(tower[query_row][query_glass], 1.0);
    }
}