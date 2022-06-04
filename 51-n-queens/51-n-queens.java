class Solution {
    
    List<List<String>> output = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        placeQueen(new int[n][n], 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return output;
    }
    
    private void placeQueen(int[][] board, int index, Set<Integer> diagonal, Set<Integer> diagonal2, Set<Integer> vertical)
    {
        //base case
        if(index == board.length)
        {
            addToOutput(board);
            return;
        }
        
        for(int i = 0; i < board.length; i++)
        {
            if(!diagonal.contains(index + i) && !diagonal2.contains(i - index) && !vertical.contains(i))
            {
                board[index][i] = 1;
                diagonal.add(index + i);
                diagonal2.add(i - index);
                vertical.add(i);
                
                placeQueen(board, index + 1, diagonal, diagonal2, vertical);
                
                board[index][i] = 0;
                diagonal.remove(index + i);
                diagonal2.remove(i - index);
                vertical.remove(i);
            }
        }
    }
    
    private void addToOutput(int[][] board)
    {
        List<String> temp = new ArrayList<>();
        
        for(int i = 0; i < board.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == 0)
                {
                    sb.append(".");
                }
                else
                {
                    sb.append("Q");
                }
            }
            
            temp.add(sb.toString());
        }
        
        output.add(temp);
    }
}