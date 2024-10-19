import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class countingrooms {
    public static void dfs(char[][] grid, int startRow, int startCol, boolean[][] visited, int[] delrow, int[] delcol) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        int n = grid.length;
        int m = grid[0].length;
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '.' && !visited[nrow][ncol]) {
                    stack.push(new int[]{nrow, ncol});
                    visited[nrow][ncol] = true;
                }
            }
        }
    }
    public static int countrooms(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    dfs(grid, i, j, visited, delrow, delcol);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = reader.readLine().toCharArray();
        }
        System.out.println(countrooms(grid));
    }
}
