package algorithm.amz;

import algorithm.UnionFind.MinTimeSendToAllServers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by muni on 2019/12/9
 */
public class ZombieInfection {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,1,0,1},
                {0,1,0,1,0},
                {0,0,0,0,1},
                {0,1,0,0,0},
        };
        System.out.println(new ZombieInfection().humanDays(matrix));
    }

    public int humanDays(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return -1;
        int n = matrix[0].length;
        if (n == 0) return -1;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int time = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (matrix[x][y] == 1) continue;
                    matrix[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }
            time++;
        }
        return time;
    }
}
