package algorithm.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0},
                {1,1,0},
                {1,1,0}};
//        int[][] grid = new int[][]{{0,1},{1,0}};
        System.out.println(new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        m = grid.length;
        if (m == 0) return -1;
        n = grid[0].length;
        if (n == 0) return -1;
        if (grid[0][0] == 1) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pos = queue.poll();
                if (pos[0] == m-1 && pos[1] == n-1) return dist;
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (visited[x][y] || grid[x][y] == 1) continue;
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            dist++;
        }
        return -1;
    }
}
