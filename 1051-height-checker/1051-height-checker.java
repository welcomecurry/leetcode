class Solution {
    public int heightChecker(int[] heights) {
        //sort array and compare and increment
        
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int unexpected = 0;
        
        for(int i = 0; i < heights.length; i++) {
            if(heights[i] != expected[i]) {
                unexpected++;
            }
        }
        
        return unexpected;
    }
}