package algorithm.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDistanceToIsland {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        System.out.println(new MaxDistanceToIsland().maxDistance(grid));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxDistance(int[][] grid) {
        m = grid.length;
        if (m == 0) return -1;
        n = grid[0].length;
        int max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                max = Math.max(max, getMinDistance(grid, queue));
            }
        }
        return max;
    }

    public int getMinDistance(int[][] grid, Queue<int[]> queue) {
        boolean[][] visited = new boolean[m][n];
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int crdX = pos[0] + dir[0];
                    int crdY = pos[1] + dir[1];
                    if (crdX < 0 || crdY < 0 || crdX >= m || crdY >= n) continue;
                    if (visited[crdX][crdY]) continue;
                    if (grid[crdX][crdY] == 1) return dist;
                    visited[crdX][crdY] = true;
                    queue.offer(new int[]{crdX, crdY});
                }
            }
            dist++;
        }
        return -1;
    }
}
