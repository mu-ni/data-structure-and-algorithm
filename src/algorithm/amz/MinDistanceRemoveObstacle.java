package algorithm.amz;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by muni on 2019/12/9
 */
public class MinDistanceRemoveObstacle {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,0},{1,0,0},{1,9,0}};
        System.out.println(new MinDistanceRemoveObstacle().minDistance(3,3, grid));
        System.out.println(new MinDistanceRemoveObstacle().minDistance2(3,3, grid));
    }

    int min = Integer.MAX_VALUE;
    int m;
    int n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minDistance(int numRows, int numColumns,int[][] grid){
        m = numRows;
        n = numColumns;
        boolean[][] visited = new boolean[m][n];
        dfs(grid, 0, 0, 0, visited);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void dfs(int[][] grid, int x, int y, int steps, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (visited[x][y] || grid[x][y] == 0) return;
        if (grid[x][y] == 9) {
            min = Math.min(min, steps);
            return;
        }
        visited[x][y] = true;
        for (int[] dir : dirs) {
            dfs(grid, x + dir[0], y + dir[1], steps+1, visited);
        }
    }

    public int minDistance2(int numRows, int numColumns,int[][] grid){
        m = numRows;
        n = numColumns;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = true;

        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++){
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (visited[x][y] || grid[x][y] == 0) continue;
                    if (grid[x][y] == 9) return steps;
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            steps++;
        }
        return -1;
    }
}
