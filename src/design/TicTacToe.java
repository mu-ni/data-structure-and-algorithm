package design;

public class TicTacToe {
    int n;
    int[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        return isWin(row, col, player) ? player : 0;
    }

    private boolean isWin(int row, int col, int player) {
        return hasRow(row, player) || hasCol(col, player) || hasDia(row, col, player);
    }

    private boolean hasRow(int row, int player) {
        for (int i=0; i<n; i++) {
            if (board[row][i] != player) return false;
        }
        return true;
    }

    private boolean hasCol(int col, int player) {
        for (int i=0; i<n; i++) {
            if (board[i][col] != player) return false;
        }
        return true;
    }

    private boolean hasDia(int row, int col, int player) {
        int count = 0;
        for (int i=0; i<n; i++) {
            if (row + col - i < 0 || row + col - i >= n) continue;
            if (board[i][row + col - i] != player) return false;
            count++;
        }
        if (count == n) return true;

        count = 0;
        for (int i=0; i<n; i++) {
            if (col - row + i < 0 || col - row + i >= n) continue;
            if (board[i][col - row + i] != player) return false;
            count++;
        }
        if (count == n) return true;

        return false;
    }

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);
        System.out.println(toe.move(0, 0, 1));
        System.out.println(toe.move(0, 2, 2));
        System.out.println(toe.move(2, 2, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(2, 0, 1));
        System.out.println(toe.move(1, 0, 2));
        System.out.println(toe.move(2, 1, 1));
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
