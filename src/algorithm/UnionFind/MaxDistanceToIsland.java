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
        System.out.println(new MaxDistanceToIsland().maxDistance2(grid));
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
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (visited[x][y]) continue;
                    if (grid[x][y] == 1) return dist;
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            dist++;
        }
        return -1;
    }

    public int maxDistance2(int[][] grid) {
        int m = grid.length;
        if (m == 0) return -1;
        int n = grid[0].length;
        if (n == 0) return -1;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        // no water exists
        if (queue.size() == m*n) return -1;

        // no land exists -> queue.isEmpty()
        int dist = -1;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (visited[x][y]) continue;
                    visited[x][y] = true;
                    queue.offer(new int[]{x,y});
                }
            }
            dist++;
        }
        return dist;
    }
}
