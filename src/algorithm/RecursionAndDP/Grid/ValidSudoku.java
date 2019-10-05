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
        System.out.println(new ValidSudoku().isValidSudoku3(board));
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
        char[] block = new char[9];
        for (int i=0; i<9; i++) {
            block[i] = board[x + i/3][y + i%3];
        }
        return block;
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
        Set<String> set = new HashSet<>();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.') continue;
                if (!set.add(board[i][j] + " in row " + i) ||
                        !set.add(board[i][j] + " in col " + j) ||
                        !set.add(board[i][j] + " in blk " + i/3 + "," + j/3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku3(char[][] board) {
        int m = board.length;
        if (m != 9) return false;
        int n = board[0].length;
        if (n != 9) return false;

        for (int i=0; i<9; i++) {
            char[] rows = board[i];
            if (hasDup(rows)) return false;

            char[] cols = new char[9];
            for (int j=0; j<9; j++) {
                cols[j] = board[j][i];
            }
            if (hasDup(cols)) return false;

            char[] block = getBlock(board, (i/3)*3, (i%3)*3);
            if (hasDup(block)) return false;
        }

        return true;
    }

    public boolean hasDup(char[] arr) {
        int[] map = new int[9];
        for (char c : arr) {
            if (c == '.') continue;
            if (map[c - '1'] != 0) return true;
            map[c - '1']++;
        }
        return false;
    }
}
