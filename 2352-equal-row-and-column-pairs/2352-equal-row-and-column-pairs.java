class Solution {
    public int equalPairs(int[][] grid) {
        //add rows to map
        //loop through columns, if the map contains a column increment count
        
        int pairs = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int[] row : grid) {
            map.put(Arrays.toString(row), map.getOrDefault(Arrays.toString(row), 0) + 1);
        }
        
        for(int i = 0; i < grid.length; i++) {
            int[] currCol = new int[grid.length];
            for(int j = 0; j < grid[0].length; j++) {
                currCol[j] = grid[j][i];
            }
            
            // Add the number of times that column appeared as a row.
                pairs += map.getOrDefault(Arrays.toString(currCol), 0);
        }
        
        return pairs;
    }
}