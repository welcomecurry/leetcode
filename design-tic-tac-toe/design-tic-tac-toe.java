class TicTacToe {

    int[][] matrix;
    public TicTacToe(int n) {
        //init nxn matrix
        matrix = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        //set the row and col to player number
        //loop left to right top and bottom
        //top to bottom on both sides
        //diagonals
        
        matrix[row][col] = player;
                
        int count = 0;
        
        //top left to right
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[row][j] == player) {
                    count++;
            }
        }
        
        if(count == matrix.length) return player;
        
        count = 0;
        
        
        //top to bottom left
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][col] == player) {
                count++;
            }
        }
        
        if(count == matrix.length) return player;
        
        count = 0;
        
        
        //diagonals
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i == j && matrix[i][j] == player) {
                    count++;
                }
            }
        }
        
                
        if(count == matrix.length) return player;
        
        count = 0;
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i + j == matrix.length - 1 && matrix[i][j] == player) {
                    count++;
                }
            }
        }
        
        if(count == matrix.length) return player;

        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */