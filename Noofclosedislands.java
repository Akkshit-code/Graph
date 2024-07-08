class Noofclosedislands {
    public void dfs(int row,int col,int [][] visited,int [][] grid,int []delrow,int []delcol){
        visited[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==0){
                dfs(nrow,ncol,visited,grid,delrow,delcol);
            }
        }
    }
    public int closedIsland(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, 1, 0, -1};
        int[][] visited = new int[n][m];

        // Traverse first row and last row
        for (int j = 0; j < m; j++) {
            if (visited[0][j] == 0 && a[0][j] == 0) {
                dfs(0, j, visited, a, delrow, delcol);
            }
            if (visited[n - 1][j] == 0 && a[n - 1][j] == 0) {
                dfs(n - 1, j, visited, a, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i][0] == 0 && a[i][0] == 0) {
                dfs(i, 0, visited, a, delrow, delcol);
            }
            if (visited[i][m - 1] == 0 && a[i][m - 1] == 0) {
                dfs(i, m - 1, visited, a, delrow, delcol);
            }
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && a[i][j] == 0) {
                    count++;
                    dfs(i,j, visited, a, delrow, delcol);
                }
            }
        }

        return count;
    }
}