class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        //take slopes
        //if slopes dont match return false since not a straight line
        //loop through starting at 2 to length and call helper
        //return true if we make through loop
        
        for(int i = 2; i < coordinates.length; i++)
        {
            if(!onLine(coordinates[i], coordinates[0], coordinates[1]))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean onLine(int[] p1, int[] p2, int[] p3)
    {
        int x = p1[0], y = p1[1], x1 = p2[0], y1 = p2[1], x2 = p3[0], y2 = p3[1];
        return ((y - y1) * (x2 - x1) == (y2 - y1) * (x - x1));    
    }
}