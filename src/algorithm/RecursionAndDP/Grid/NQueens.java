package algorithm.RecursionAndDP.Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rst = new ArrayList<>();
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(arr -> Arrays.fill(arr, '.'));
        dfs(board, 0, rst);
        return rst;
    }

    public void dfs(char[][] board, int colIndex, List<List<String>> rst) {
        if (colIndex == board.length) {
            rst.add(array2list(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (!idValid(board, i, colIndex)) {
                continue;
            }
            board[i][colIndex] = 'Q';
            dfs(board, colIndex + 1, rst);
            board[i][colIndex] = '.';
        }
    }

    public List<String> array2list(char[][] board) {
        return Arrays.stream(board)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public boolean idValid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q' && isInline(i, j, x ,y)) {
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
