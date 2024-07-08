class Surrounderegion {
    public void dfs(int row, int col, char[][] board, int[][] visited, int[] delrow, int[] delcol) {
        visited[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, board, visited, delrow, delcol);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        // Traversing in the first and last row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && visited[0][j] == 0) {
                dfs(0, j, board, visited, delrow, delcol);
            }
            if (board[n - 1][j] == 'O' && visited[n - 1][j] == 0) {
                dfs(n - 1, j, board, visited, delrow, delcol);
            }
        }

        // Traversing in the first and last column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && visited[i][0] == 0) {
                dfs(i, 0, board, visited, delrow, delcol);
            }
            if (board[i][m - 1] == 'O' && visited[i][m - 1] == 0) {
                dfs(i, m - 1, board, visited, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }
}