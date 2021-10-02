class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] twoD = new int[m][n];
        int index = 0;
        
        if(original.length != m * n) return new int[][] {};
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(index < original.length)
                    twoD[i][j] = original[index++];
            }
        }
        
        return twoD;
    }
}