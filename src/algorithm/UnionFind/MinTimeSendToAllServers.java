package algorithm.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

public class MinTimeSendToAllServers {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,1,0,1},
                {0,1,0,1,0},
                {0,0,0,0,1},
                {0,1,0,0,0},
        };
        System.out.println(new MinTimeSendToAllServers().minTimeSendToAllServers(4, 5, grid));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int minTimeSendToAllServers(int r, int c, int[][] grid) {
        m = r;
        n = c;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int time = 0;
        while (true) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (grid[x][y] == 1) continue;
                    grid[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }
            if (queue.isEmpty()) break;
            time++;
        }

        return time;
    }
}
