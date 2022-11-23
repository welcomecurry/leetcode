class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++)
        {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.' && !row.add(board[i][j]))
                {
                    return false;
                }
                
                if(board[j][i] != '.' && !col.add(board[j][i]))
                {
                    return false;
                }
                
                int r = 3 * (i / 3);
                int c = 3 * (i % 3);
                
                if(board[r + j / 3][c + j % 3] != '.' && !box.add(board[r + j / 3][c + j % 3]))
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}