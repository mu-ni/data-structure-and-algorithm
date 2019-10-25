package algorithm.UnionFind;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = new int[]{3,0};
        System.out.println(Arrays.deepToString(new Minesweeper().updateBoard(board, click)));
        click = new int[]{1,2};
        System.out.println(Arrays.deepToString(new Minesweeper().updateBoard2(board, click)));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};

    // DFS
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        int count = 0;
        for (int[] dir : dirs) {
            int x = click[0] + dir[0];
            int y = click[1] + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n) continue;
            if (board[x][y] == 'M') count++;
        }

        if (count > 0) {
            board[click[0]][click[1]] = (char)(count + '0');
            return board;
        }
        board[click[0]][click[1]] = 'B';
        for (int[] dir : dirs) {
            int x = click[0] + dir[0];
            int y = click[1] + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n) continue;
            if (board[x][y] == 'E') updateBoard(board, new int[]{x, y});
        }
        return board;
    }

    // BFS
    public char[][] updateBoard2(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int count = 0;
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n) continue;
                if (board[x][y] == 'M') count++;
            }
            if (count > 0) {
                board[pos[0]][pos[1]] = (char)(count + '0');
                continue;
            }
            board[pos[0]][pos[1]] = 'B';
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n) continue;
                if (board[x][y] == 'E') {
                    queue.offer(new int[]{x, y});
                    board[x][y] = 'B';
                }
            }
        }
        return board;
    }
}
