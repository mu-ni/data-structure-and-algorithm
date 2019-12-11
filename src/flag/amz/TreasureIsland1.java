package flag.amz;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by muni on 2019/12/9
 */
public class TreasureIsland1 {
    public static void main(String[] args) {
        char[][] map = new char[][]{
                {'O','O','O','O'},
                {'D','O','D','O'},
                {'O','O','O','O'},
                {'X','D','D','O'}};
        System.out.println(new TreasureIsland1().treasureIsland(map));
        System.out.println(new TreasureIsland1().treasureIsland2(map));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int min = Integer.MAX_VALUE;
    public int treasureIsland(char[][] map) {
        m = map.length;
        n = map[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(map, 0, 0, 0, visited);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void dfs(char[][] map, int x, int y, int steps, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (visited[x][y] || map[x][y] == 'D') return;
        if (map[x][y] == 'X') {
            min = Math.min(min, steps);
            return;
        }

        visited[x][y] = true;
        for (int[] dir : dirs) {
            dfs(map, x + dir[0], y + dir[1], steps+1, visited);
        }
    }

    public int treasureIsland2(char[][] map) {
        m = map.length;
        n = map[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        boolean[][] visited = new boolean[m][n];

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (visited[x][y] || map[x][y] == 'D') continue;
                    if (map[x][y] == 'X') return step;
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            step++;
        }
        return -1;
    }
}
