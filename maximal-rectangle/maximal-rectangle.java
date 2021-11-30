class Solution {
    public int maximalRectangle(char[][] matrix) {
        //convert input into largest rectangle in histogram, row by row or col by col
        //then run largest histogram, modified for a char matrix
                
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
                
        int row = matrix.length, col = matrix[0].length;
        
        if(row > col)
        {
            return largestRectangleArea(matrix, row, col, true);
        }
        else
        {
            return largestRectangleArea(matrix, col, row, false);
        }
    }
    
    private int largestRectangleArea(char[][] matrix, int big, int small, boolean isColsSmall)
    {
        int[] heights = new int[small];
        int largest = 0;
        
        for(int i = 0; i < big; i++)
        {
            Stack<Integer> stack = new Stack<>();
            
            for(int j = 0; j <= small; j++)
            {
                if(j < small)
                {
                    if(isColsSmall)
                    {
                        heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
                    }
                    else
                    {
                        heights[j] = matrix[j][i] == '0' ? 0 : heights[j] + 1;
                    }
                }
                
                while(!stack.isEmpty() && (j == small || heights[stack.peek()] >= heights[j]))
                {
                    int currHeight = heights[stack.pop()];
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    largest = Math.max(largest, (j - 1 - left) * currHeight);
                }
                
                stack.push(j);
            }
        }
        
        return largest;
    }
}