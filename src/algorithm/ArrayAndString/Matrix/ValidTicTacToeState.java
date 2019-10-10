package algorithm.ArrayAndString.Matrix;

public class ValidTicTacToeState {
    public static void main(String[] args) {
        System.out.println(new ValidTicTacToeState().validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
    }

    public boolean validTicTacToe(String[] board) {
        int xNum = 0;
        int oNum = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') xNum++;
                if (c == 'O') oNum++;
            }
        }

        if (oNum > xNum) return false;
        if (xNum - oNum > 1) return false;
        if (isWin(board, 'X') && isWin(board, 'O')) return false;
        if (isWin(board, 'X') && oNum >= xNum) return false;
        if (isWin(board, 'O') && oNum < xNum) return false;

        return true;
    }

    public boolean isWin(String[] board, char c) {
        return hasValidRow(board, c) || hasValidCol(board, c) || hasValidDia(board, c);
    }

    public boolean hasValidRow(String[] board, char c) {
        for (int i=0; i<3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
        }
        return false;
    }

    public boolean hasValidCol(String[] board, char c) {
        for (int i=0; i<3; i++) {
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) return true;
        }
        return false;
    }

    public boolean hasValidDia(String[] board, char c) {
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;
        return false;
    }
}
