class Solution {
    public void solve(char[][] board) {
        //loop through and call dfs on border setting to different letter
        //loop through again and if current letter is different set to O otherwise x
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1))
                {
                    if(board[i][j] == 'O')
                        dfs(board, i, j);
                }
            }
        }
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] != 'S')
                {
                    board[i][j] = 'X';
                }
                else
                {
                    board[i][j] = 'O';
                }
            }
        }        
    }
    
    private void dfs(char[][] board, int i, int j)
    {
        //base case if we are in bounds and current element is a O
        //mark current cell as S
        //call dfs in all directions
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
        {
            return;
        }
        
        board[i][j] = 'S';
        
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
    }
}