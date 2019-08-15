package algorithm.RecursionAndDP;

import java.util.*;

public class SolveSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solveSudoku(char[][] board) {
        isSolved(board);
    }

    public static boolean isSolved(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char c = '1'; c <= '9'; c++) {
                    if (!isValid(board, i, j, c)) continue;
                    board[i][j] = c;
                    if (isSolved(board)) return true;
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        int blkrow = (row / 3) * 3;
        int blkcol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[blkrow+i/3][blkcol+i%3] == c) return false;
        }
        return true;
    }
}
