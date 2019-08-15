package algorithm.RecursionAndDP;

public class NQueens2 {
    public static void main(String[] args) {
        NQueens2 nQueens2 = new NQueens2();
        System.out.println(nQueens2.totalNQueens(8));
        System.out.println(nQueens2.totalNQueens2(8));
    }

    public int rst = 0;
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        dfs(board, 0);
        return rst;
    }

    public void dfs(boolean[][] board, int colIndex) {
        if (colIndex == board.length) {
            rst++;
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


    public int rst2 = 0;
    public int totalNQueens2(int n) {
        boolean[] rows = new boolean[n];
        boolean[] dia1 = new boolean[n*2]; // x1+y1 = x2+y2
        boolean[] dia2 = new boolean[n*2]; // x1+y2 = x2+y1
        dfs(0, rows, dia1, dia2);
        return rst2;
    }

    public void dfs(int colIndex, boolean[] rows, boolean[] dia1, boolean[] dia2) {
        if (colIndex == rows.length) {
            rst2++;
            return;
        }
        for (int i=0; i<rows.length; i++) {
            int d1 = i + colIndex;
            int d2 = i - colIndex + rows.length;
            if (rows[i] || dia1[d1] || dia2[d2]) {
                continue;
            }
            rows[i] = true;
            dia1[d1] = true;
            dia2[d2] = true;
            dfs(colIndex+1, rows, dia1, dia2);
            rows[i] = false;
            dia1[d1] = false;
            dia2[d2] = false;
        }
    }
}
