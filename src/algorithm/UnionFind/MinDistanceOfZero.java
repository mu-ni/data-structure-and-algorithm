package algorithm.UnionFind;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinDistanceOfZero {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(Arrays.deepToString(new MinDistanceOfZero().updateMatrix(matrix)));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return new int[0][0];
        n = matrix[0].length;
        int[][] rst = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) continue;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                int min = bfs(matrix, queue);
                rst[i][j] = min;
            }
        }
        return rst;
    }

    public int bfs(int[][] matrix, Queue<int[]> queue) {
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (matrix[x][y] == 0) return dist;
                    queue.offer(new int[]{x, y});
                }
            }
            dist++;
        }
        return -1;
    }
}
