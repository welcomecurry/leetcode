class Solution {
    public boolean exist(char[][] board, String word) {
        //dfs
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, int index, String word)
    {
        if(index == word.length()) return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
        {
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = ' ';
        
        boolean found = dfs(board, i - 1, j, index + 1, word) 
            || dfs(board, i + 1, j, index + 1, word)
            || dfs(board, i, j - 1, index + 1, word)
            || dfs(board, i, j + 1, index + 1, word);
        
        board[i][j] = temp;
        
        return found;   
    }
}