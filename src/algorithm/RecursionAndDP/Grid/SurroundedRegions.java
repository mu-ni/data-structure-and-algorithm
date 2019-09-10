package algorithm.RecursionAndDP.Grid;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new SurroundedRegions().solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i=0; i<m; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board, visited);
            if (board[i][n-1] == 'O') dfs(i, n-1, board, visited);
        }
        for (int j=0; j<n; j++) {
            if (board[0][j] == 'O') dfs(0, j, board, visited);
            if (board[m-1][j] == 'O') dfs(m-1, j, board, visited);
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if (visited[i][j] || board[i][j] != 'O') return;
        visited[i][j] = true;
        dfs(i-1, j, board, visited);
        dfs(i+1, j, board, visited);
        dfs(i, j-1, board, visited);
        dfs(i, j+1, board, visited);
    }
}
