public class depthoftunnel {
    public static int dfs(int [][] grid,int row,int col,boolean [][] visited,int [] delrow,int [] delcol){
        visited[row][col]=true;
        int n=grid.length;
        int m=grid[0].length;
        int max=row;
        for (int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==false && grid[nrow][ncol]==1){
                int newrow=dfs(grid,nrow,ncol,visited,delrow,delcol);
                if(max<newrow) max=newrow;
            }
        }
        return max;
    }
    public static int depth(int [][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] visited=new boolean[n][m];
        int [] delrow={-1,0,1,0};
        int [] delcol={0,1,0,-1};
        int max=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int ans=dfs(grid,i,j,visited,delrow,delcol);
                    if(max<ans) max=ans;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int maxDepth = depth(grid);
        System.out.println("Maximum depth of the tunnel: " + maxDepth);
    }
}
