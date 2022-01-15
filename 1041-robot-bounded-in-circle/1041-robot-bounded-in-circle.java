class Solution {
    public boolean isRobotBounded(String instructions) {
        //init directions
        //init x and y
        //init index to denote direction
        //loop through instructions
        //if we are going left we are going counter clockwise i + 3 % 4
        //if we are going righr we are going clockwise i + 1 % 4
        //otherwise if we are going straight calculate
        //return if x and y is 0 or direction > 0, displacement is 0
        
        int dir[][] = {
            {0,1},  //North
            {1,0},  //East
            {0,-1}, //South
            {-1,0}  //West
        };
        
        // i = 0 --> North/Up
        // i = 1 --> East/Right
        // i = 2 --> South/Down
        // i = 3 --> West/Left
        int x = 0, y = 0, i = 0;
        
        for(char c : instructions.toCharArray())
        {
            if(c == 'L')
            {
                i = (i + 3) % 4;
            }
            else if(c == 'R')
            {
                i = (i + 1) % 4;
            }
            else
            {
                x += dir[i][0];
                y += dir[i][1];
            }
        }
        
        return x == 0 && y == 0 || i > 0;
    }
}