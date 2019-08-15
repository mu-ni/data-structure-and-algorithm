package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }

        for (char[] arr : board) {
            if (!isUnique(arr)) return false;
        }

        for (int i=0; i<9; i++) {
            char[] arr = new char[9];
            for (int j=0; j<9; j++) {
                arr[j] = board[j][i];
            }
            if(!isUnique(arr)) return false;
        }

        for (int i=0; i<9; i+=3) {
            for (int j=0; j<9; j+=3) {
                if (!isUnique(getBlock(board, i, j))) return false;
            }
        }

        return true;
    }

    public static char[] getBlock(char[][] board, int x, int y) {
        List<Character> list = new ArrayList<>();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                list.add(board[x+i][y+j]);
            }
        }

        char[] arr = new char[9];
        for (int i=0; i<9; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static boolean isUnique(char[] arr) {
        Set<Character> set = new HashSet<>();
        int num = 0;
        for (char a : arr) {
            if (a == '.') continue;
            set.add(a);
            num++;
        }
        return num == set.size();
    }
}
