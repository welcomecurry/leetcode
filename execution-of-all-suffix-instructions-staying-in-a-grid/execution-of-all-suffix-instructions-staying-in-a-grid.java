class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        //create a matrix of size n*n
        //create output of s.length()
        //loop through length of s
        //take substring from i to length
        //peroform the operations, if we go out of bounds break and log the instructions
        //otherwise just log
        
        int[][] mat = new int[n][n];
        int[] output = new int[s.length()];
        int x = startPos[0], y = startPos[1];
        
        for(int i = 0; i < s.length(); i++)
        {
            String curr = s.substring(i);
            int currInstructions = 0;
            
            for(char move : curr.toCharArray())
            {
                int[] op = getOp(move);
                x += op[0];
                y += op[1];
                
                if(outOfBounds(mat, x, y)) break;
                
                currInstructions++;
            }
            
            //reset positions
            x = startPos[0];
            y = startPos[1];
            
            output[i] = currInstructions;
        }
        
        return output;
    }
    
    private boolean outOfBounds(int[][] mat, int x, int y)
    {
        return x < 0 || x >= mat.length || y < 0 || y >= mat[0].length;
    }
    
    private int[] getOp(char move)
    {
        if(move == 'L') return new int[] {0, -1};
        else if(move == 'R') return new int[] {0, 1};
        else if(move == 'U') return new int[] {-1, 0};
        else return new int[] {1, 0};
    }
}