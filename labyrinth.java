import java.util.*;

class Labyrinth {
    static final int[] delrow = {-1, 0, +1, 0}; // U, R, D, L
    static final int[] delcol = {0, +1, 0, -1};
    static final char[] directions = {'U', 'R', 'D', 'L'};

    public static void bfs(char[][] grid, int startRow, int startCol, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        int[][] parent = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        for (int[] row : parent) Arrays.fill(row, -1);

        boolean found = false;
        int endRow = -1, endCol = -1;

        while (!queue.isEmpty() && !found) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if (grid[row][col] == 'B') {
                endRow = row;
                endCol = col;
                found = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] != '#') {
                    queue.add(new int[]{nrow, ncol});
                    visited[nrow][ncol] = true;
                    parent[nrow][ncol] = i; // Record the move that brought us here
                }
            }
        }

        if (found) {
            List<Character> path = new ArrayList<>();
            int row = endRow;
            int col = endCol;
            while (row != startRow || col != startCol) {
                int move = parent[row][col];
                path.add(directions[move]);
                row -= delrow[move];
                col -= delcol[move];
            }
            Collections.reverse(path);

            System.out.println("YES");
            System.out.println(path.size());
            for (char direction : path) {
                System.out.print(direction);
            }
            System.out.println();
        } else {
            System.out.println("NO");
        }
    }

    public static void labyrinth(char[][] grid, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    bfs(grid, i, j, n, m); // Start BFS from 'A'
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            grid[i] = line.toCharArray();
        }
        labyrinth(grid, n, m);
    }
}