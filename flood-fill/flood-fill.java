class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //easy dfs
        if(image[sr][sc] == newColor) return image;
        
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor)
    {
        //base case if in bounds and equals old color
        //set color
        //left right up down 
        
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor)
        {
            return;
        }
        
        image[sr][sc] = newColor;
        dfs(image, sr, sc - 1, newColor, oldColor); //left
        dfs(image, sr, sc + 1, newColor, oldColor); //right
        dfs(image, sr - 1, sc, newColor, oldColor); //up
        dfs(image, sr + 1, sc, newColor, oldColor); //down
    }
}