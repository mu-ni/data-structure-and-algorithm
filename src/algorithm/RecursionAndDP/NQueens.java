package algorithm.RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> rst = new ArrayList<>();
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(arr -> Arrays.fill(arr, '.'));
        dfs(board, 0, rst);
        return rst;
    }

    public static void dfs(char[][] board, int colIndex, List<List<String>> rst) {
        if (colIndex == board.length) {
            rst.add(array2list(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (!validate(board, i, colIndex)) {
                continue;
            }
            board[i][colIndex] = 'Q';
            dfs(board, colIndex + 1, rst);
            board[i][colIndex] = '.';
        }
    }

    public static List<String> array2list(char[][] board) {
        return Arrays.stream(board)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public static boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }
}
