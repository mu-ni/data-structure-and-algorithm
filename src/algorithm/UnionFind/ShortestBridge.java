package algorithm.UnionFind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        System.out.println(new ShortestBridge().shortestBridge(A));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestBridge(int[][] A) {
        m = A.length;
        if (m == 0) return -1;
        n = A[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    dfs(A, i, j, visited, queue);
                    return minDistance(A, visited, queue);
                }
            }
        }
        return -1;
    }

    public void dfs(int[][] A, int x, int y, boolean[][] visited, Queue<int[]> queue) {
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (A[x][y] == 0 || visited[x][y]) return;

        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        dfs(A, x + 1, y, visited, queue);
        dfs(A, x - 1, y, visited, queue);
        dfs(A, x, y + 1, visited, queue);
        dfs(A, x, y - 1, visited, queue);
    }

    public int minDistance(int[][] A, boolean[][] visited, Queue<int[]> queue) {
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] crd = queue.poll();
                for (int[] dir : dirs) {
                    int x = crd[0] + dir[0];
                    int y = crd[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) continue;
                    if (A[x][y] == 1) return dist;
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            dist++;
        }
        return -1;
    }
}
