class Solution {
    public int findMinArrowShots(int[][] points) {
        //sort the array acesding by end values
        //keep arrow count starting at 1 since we need to shoot at least 1 arrow
        //keep end value initialized at point[0][1];
        //loop through the points
        // if our start point > end point
        //increment arrow
        //new end == start points end point that was greater than end point
        //return arrow
        
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int arrows = 1, endVal = points[0][1];
        
        for(int[] point : points) {
            if(point[0] > endVal) {
                arrows++;
                endVal = point[1];
            }
        }
        
        return arrows;
    }
}