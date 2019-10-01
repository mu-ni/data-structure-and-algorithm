package algorithm.UnionFind;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new SurroundedRegions().solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    int m;
    int n;
    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) return;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            dfs(board, i, 0, visited);
            dfs(board, i, n-1, visited);
        }
        for (int j=0; j<n; j++) {
            dfs(board, 0, j, visited);
            dfs(board, m-1, j, visited);
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (board[x][y] != 'O' || visited[x][y]) return;

        visited[x][y] = true;
        dfs(board, x+1, y, visited);
        dfs(board, x-1, y, visited);
        dfs(board, x, y+1, visited);
        dfs(board, x, y-1, visited);
    }
}
