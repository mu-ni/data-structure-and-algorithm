package algorithm.RecursionAndDP.Grid;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
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
        System.out.println(new ValidSudoku().isValidSudoku(board));
        System.out.println(new ValidSudoku().isValidSudoku2(board));
    }

    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            if (!isUnique(row)) return false;

            char[] col = new char[9];
            for (int j = 0; j < 9; j++) {
                col[j] = board[j][i];
            }
            if (!isUnique(col)) return false;

            char[] block = getBlock(board, (i / 3) * 3, (i % 3) * 3);
            if (!isUnique(block)) return false;
        }

        return true;
    }

    public char[] getBlock(char[][] board, int x, int y) {
        char[] arr = new char[9];
        int blkrow = (x / 3) * 3;
        int blkcol = (y / 3) * 3;
        for (int i = 0; i < 9; i++) {
            arr[i] = board[blkrow + i / 3][blkcol + i % 3];
        }
        return arr;
    }

    public boolean isUnique(char[] arr) {
        Set<Character> set = new HashSet<>();
        int num = 0;
        for (char a : arr) {
            if (a == '.') continue;
            set.add(a);
            num++;
        }
        return num == set.size();
    }

    public boolean isValidSudoku2(char[][] board) {
        Set set = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (!set.add(c + " in row " + i)
                        || !set.add(c + " in column " + j)
                        || !set.add(c + " in block " + i / 3 + "-" + j / 3))
                    return false;
            }
        }
        return true;
    }
}
