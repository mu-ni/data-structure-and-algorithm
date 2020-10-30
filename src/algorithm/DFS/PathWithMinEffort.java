package algorithm.DFS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by muni on 2020/10/30
 */
public class PathWithMinEffort {
    public static void main(String[] args) {
        int[][] heights = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(new PathWithMinEffort().minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[][] dist = new int[m][n];
        for (int i=0; i<m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{0,0,0}); // dist, x, y
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int x = cur[1];
            int y = cur[2];
            if (x == m-1 && y == n-1) return d;
            for (int[] dir : dirs) {
                int x2 = x + dir[0];
                int y2 = y + dir[1];
                if (x2 < 0 || y2 < 0 || x2 >= m || y2 >= n) continue;
                int d2 = Math.max(d, Math.abs(heights[x2][y2] - heights[x][y]));
                if (dist[x2][y2] <= d2) continue;
                dist[x2][y2] = d2;
                pq.offer(new int[]{d2, x2, y2});
            }
        }
        return -1;
    }
}
