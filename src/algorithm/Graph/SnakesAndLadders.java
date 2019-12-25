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

    int n;
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        if (n == 0) return -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        int move = 0;
        int dest = n * n;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (num == dest) return move;
                // x+1, x+2, x+3, x+4, x+5, or x+6
                for (int j = 1; j <= 6; j++) {
                    int next = num + j;
                    if (next > dest) continue;
                    int value = getBoardValue(board, next);
                    next = value == -1 ? next : value;
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
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
        return board[x][y];
    }
}
