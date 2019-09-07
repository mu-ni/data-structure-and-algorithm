package algorithm.RecursionAndDP.Grid;

public class NQueens2 {
    public static void main(String[] args) {
        NQueens2 nQueens2 = new NQueens2();
        System.out.println(nQueens2.totalNQueens(8));
        System.out.println(nQueens2.totalNQueens2(8));
    }

    int rst = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] dia1 = new boolean[n*2];
        boolean[] dia2 = new boolean[n*2];
        backtrack(n, 0, cols, dia1, dia2);
        return rst;
    }

    public void backtrack(int n, int row, boolean[] cols, boolean[] dia1, boolean[] dia2) {
        if (row == n) {
            rst++;
            return;
        }
        for (int col=0; col < n; col++) {
            int d1 = row+col;
            int d2 = row-col+n;
            if (cols[col] || dia1[d1] || dia2[d2]) continue;

            cols[col] = true;
            dia1[d1] = true;
            dia2[d2] = true;
            backtrack(n, row+1, cols, dia1, dia2);
            cols[col] = false;
            dia1[d1] = false;
            dia2[d2] = false;
        }
    }

    public int rst2 = 0;
    public int totalNQueens2(int n) {
        boolean[][] board = new boolean[n][n];
        dfs(board, 0);
        return rst2;
    }

    public void dfs(boolean[][] board, int colIndex) {
        if (colIndex == board.length) {
            rst2++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (!isValid(board, i, colIndex)) {
                continue;
            }
            board[i][colIndex] = true;
            dfs(board, colIndex + 1);
            board[i][colIndex] = false;
        }
    }

    public boolean isValid(boolean[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == true && isInline(i, j, x ,y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isInline(int x1, int y1, int x2, int y2) {
        return x1 == x2 || y1 == y2 || x1 + y1 == x2 + y2 || x1 + y2 == x2 + y1;
    }

}
