class Solution {
    public int[][] diagonalSort(int[][] mat) {
        //init hashmap with key as integer which represents digaonal number and value that is pq
        //loop through matrix
        //map.computeIfAbsent(i - j, p -> new pq.add(mat[i][j])), i - j is diagonal number
        //loop through matrix again and fill matrix with sorted values by polling off heap
        //return mat
        
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                map.computeIfAbsent(i - j, p -> new PriorityQueue<Integer>()).add(mat[i][j]);
            }
        }
        
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        
        return mat;
    }
}