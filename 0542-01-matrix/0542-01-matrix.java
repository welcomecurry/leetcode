class Solution {
    class Pair{
        int row,col,dist;
        Pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public boolean isValid(int row,int col,int[][]mat){
        if(row >=0 && row < mat.length && col >=0&&col<mat[0].length){return true;}
        return false;
    }
    public int[][] updateMatrix(int[][] mat) {
        int out[][]=new int[mat.length][mat[0].length];
        int dir[][]=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        Queue<Pair>q=new LinkedList<Pair>();
        for(int i=0;i<mat.length;i++){
            for(int j=0; j<mat[0].length ;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            for(int i=0;i<dir.length;i++){
                int row=p.row+dir[i][0];
                int col=p.col+dir[i][1];
                if(isValid(row,col,mat) && mat[row][col]==1){
                    q.add(new Pair(row,col,p.dist+1));
                    mat[row][col]=0;
                    out[row][col]=p.dist+1;
                }
            }
        }
        return out;
    }
}