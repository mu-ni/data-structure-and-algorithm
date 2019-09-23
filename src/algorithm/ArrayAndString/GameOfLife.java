package algorithm.ArrayAndString;

import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        new GameOfLife().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1,1}, {-1, -1}, {-1, 1}, {1, -1}};
    int ALIVE = 1;
    int DEAD = 0;
    int DEAD_TO_ALIVE = 2;
    int ALIVE_TO_DEAD = 3;
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        if (m == 0) return;
        n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int num = getAliveNeighborNum(board, i, j);
                if (board[i][j] == ALIVE && (num < 2 || num > 3)) {
                    board[i][j] = ALIVE_TO_DEAD;
                    continue;
                }
                if (board[i][j] == DEAD && num == 3) {
                    board[i][j] = DEAD_TO_ALIVE;
                    continue;
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == ALIVE_TO_DEAD) {
                    board[i][j] = DEAD;
                    continue;
                }
                if (board[i][j] == DEAD_TO_ALIVE) {
                    board[i][j] = ALIVE;
                    continue;
                }
            }
        }
    }

    public int getAliveNeighborNum(int[][] board, int x, int y) {
        int num = 0;
        for (int[] dir : directions) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if (dx < 0 || dy < 0 || dx >= m || dy >= n) continue;
            if (board[dx][dy] == ALIVE || board[dx][dy] == ALIVE_TO_DEAD) {
                num ++;
            }
        }
        return num;
    }
}
