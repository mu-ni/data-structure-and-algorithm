package algorithm.amz;

/**
 * Created by muni on 2019/12/9
 */
public class TreasureIsland2 {
    public static void main(String[] args) {
        char[][] map = new char[][]{
                {'S','O','O','S','S'},
                {'D','O','D','O','D'},
                {'O','O','O','O','X'},
                {'X','D','D','O','O'},
                {'X','D','D','D','O'},
        };
        System.out.println(new TreasureIsland2().treasureIsland(map));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int min = Integer.MAX_VALUE;
    public int treasureIsland(char[][] map) {
        m = map.length;
        n = map[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] != 'S') continue;
                boolean[][] visited = new boolean[m][n];
                dfs(map, i, j, 0, visited);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void dfs(char[][] map, int x, int y, int steps, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (visited[x][y] || map[x][y] == 'D') return;
        if (steps != 0 && map[x][y] == 'S') return;
        if (map[x][y] == 'X') {
            min = Math.min(min, steps);
            return;
        }

        visited[x][y] = true;
        for (int[] dir : dirs) {
            dfs(map, x + dir[0], y + dir[1], steps+1, visited);
        }
    }
}
