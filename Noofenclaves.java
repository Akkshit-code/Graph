class Noofenclaves {
    public void dfs(int row, int col, int[][] visited, int[][] a, int[] delrow, int[] delcol) {
        visited[row][col] = 1;
        int n = a.length;
        int m = a[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && a[nrow][ncol] == 1) {
                dfs(nrow, ncol, visited, a, delrow, delcol);
            }
        }
    }

    public int numEnclaves(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, 1, 0, -1};
        int[][] visited = new int[n][m];

        // Mark all land cells connected to the boundary as visited
        for (int j = 0; j < m; j++) {
            if (a[0][j] == 1 && visited[0][j] == 0) {
                dfs(0, j, visited, a, delrow, delcol);
            }
            if (a[n - 1][j] == 1 && visited[n - 1][j] == 0) {
                dfs(n - 1, j, visited, a, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i][0] == 1 && visited[i][0] == 0) {
                dfs(i, 0, visited, a, delrow, delcol);
            }
            if (a[i][m - 1] == 1 && visited[i][m - 1] == 0) {
                dfs(i, m - 1, visited, a, delrow, delcol);
            }
        }

        // Count the number of enclaves
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && a[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}