package algorithm.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {0,1,0},
                {0,0,0},
                {0,0,1}
        };
        System.out.println(new ShortestBridge().shortestBridge(A));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] A) {
        m = A.length;
        if (m == 0) return 0;
        n = A[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        boolean found = false;
        for (int i = 0; i < m; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;
                dfs(A, i, j, visited, queue);
                found = true;
                break;
            }
        }

        return minDistance(A, visited, queue);
    }

    // mark island
    public void dfs(int[][] A, int x, int y, boolean[][] visited, Queue<int[]> queue) {
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (visited[x][y] || A[x][y] == 0) return;

        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        for (int[] dir : dirs) {
            dfs(A, x + dir[0], y + dir[1], visited, queue);
        }
    }

    // expand dist
    public int minDistance(int[][] A, boolean[][] visited, Queue<int[]> queue) {
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) continue;
                    if (A[x][y] == 1) return dist;
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            dist++;
        }

        return -1;
    }
}
