package algorithm.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadders {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(new SnakesAndLadders().snakesAndLadders(board));
    }

    int m;
    int n;

    public int snakesAndLadders(int[][] board) {
        m = board.length;
        if (m == 0) return -1;
        n = board[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        int move = 0;
        int dest = m * n;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (num == dest) return move;
                for (int j = 1; j <= 6; j++) {
                    if (num + j > dest) continue;
//                    int value = getBoardValue(board, next);
//                    next = value == -1 ? next : value;
                    int[] pos = getCoordinate(num + j, m, n);
                    int next = board[pos[0]][pos[1]] == -1 ? num + j : board[pos[0]][pos[1]];
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            move++;
        }
        return -1;
    }

    public int getBoardValue(int[][] board, int num) {
        int x = m - 1 - (num - 1) / n;
        int y = (num - 1) % n;
        if (y % 2 == m % 2) return board[x][n - 1 - y];
//        int n = board.length;
//        int r = (num - 1) / n;
//        int x = n - 1 - r;
//        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;

        return board[x][y];
    }

    public int[] getCoordinate(int n, int rows, int cols) {
        int r = rows - 1 - (n - 1) / cols;
        int c = (n - 1) % cols;
        if (r % 2 == rows % 2) {
            return new int[]{r, cols - 1 - c};
        } else {
            return new int[]{r, c};
        }
    }
}
