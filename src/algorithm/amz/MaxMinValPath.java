package algorithm.amz;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by muni on 2019/12/9
 */
public class MaxMinValPath {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {7,5,3},
                {2,0,9},
                {4,5,9}
        };
        System.out.println(new MaxMinValPath().maxPathScore(matrix));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int maxPathScore(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        maxHeap.offer(new int[]{0, 0, matrix[0][0]});
        visited[0][0] = true;

        int rst = matrix[0][0];
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            rst = Math.min(rst, cur[2]);
            if (cur[0] == m-1 && cur[1] == n-1) {
                return rst;
            }

            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                if (visited[x][y]) continue;
                visited[x][y] = true;
                maxHeap.offer(new int[]{x, y, matrix[x][y]});
            }

        }
        return rst;
    }
}
