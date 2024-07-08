class Noofislands {
    public void dfs(int row,int col,char [][] grid,int [][] visited,int []delrow,int []delcol){
        visited[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                dfs(nrow,ncol,grid,visited,delrow,delcol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][] visited=new int[n][m];
        int count=0;
        int []delrow={-1,0,+1,0};
        int []delcol={0,+1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    count++;
                    dfs(i,j,grid,visited,delrow,delcol);
                }
            }
        }
        return count;
    }
}