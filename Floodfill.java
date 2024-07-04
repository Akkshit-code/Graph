class Floodfill {
    public void dfs(int row,int col,int [][]ans,int [][] image,int newcolor,int [] delrow,int [] delcol,int incolor){
        ans[row][col]=newcolor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==incolor && ans[nrow][ncol] != newcolor){
                dfs(nrow,ncol,ans,image,newcolor,delrow,delcol,incolor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int incolor=image[sr][sc];
        int [][] ans=image;
        int []delrow={-1,0,+1,0};
        int []delcol={0,+1,0,-1};
        dfs(sr,sc,ans,image,color,delrow,delcol,incolor);
        return ans;
    }
}