package algorithm.RecursionAndDP.Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
        System.out.println(nQueens.solveNQueens2(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rst = new ArrayList<>();
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(arr -> Arrays.fill(arr, '.'));
        backtrack(board, 0, rst);
        return rst;
    }

    public void backtrack(char[][] board, int x, List<List<String>> rst) {
        if (x == board.length) {
            rst.add(array2list(board));
            return;
        }

        for (int j=0; j<board.length; j++) {
            board[x][j] = 'Q';
            if (isValid(board, x, j)) {
                backtrack(board, x+1, rst);
            }
            board[x][j] = '.';
        }
    }

    public boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == x && j == y) continue;
                if (board[i][j] == 'Q' && isInline(i, j, x ,y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> rst = new ArrayList<>();
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(arr -> Arrays.fill(arr, '.'));
        backtrack2(rst, board, 0);
        return rst;
    }

    public void backtrack2(List<List<String>> rst, char[][] board, int row) {
        if (row == board.length) {
            rst.add(array2list(board));
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            if (!isValid2(board, row, col)) continue;
            board[row][col] = 'Q';
            backtrack2(rst, board, row+1);
            board[row][col] = '.';
        }
    }

    public boolean isValid2(char[][] board, int row, int col) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (isInline(i, j, row ,col)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> array2list(char[][] board) {
        return Arrays.stream(board)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public boolean isInline(int x1, int y1, int x2, int y2) {
        return x1 == x2 || y1 == y2 || x1 + y1 == x2 + y2 || x1 + y2 == x2 + y1;
    }
}
