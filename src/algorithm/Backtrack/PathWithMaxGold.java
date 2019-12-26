package algorithm.Backtrack;

public class PathWithMaxGold {

    public static void main(String[] args) {
        System.out.println(new PathWithMaxGold().getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
        System.out.println(new PathWithMaxGold().getMaximumGold2(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) continue;
                int count = backtrack(grid, i, j, visited, 0);
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public int backtrack(int[][] grid, int x, int y, boolean[][] visited, int count) {
        if (x < 0 || y < 0 || x >= m || y >= n) return count;
        if (grid[x][y] == 0 || visited[x][y]) return count;

        visited[x][y] = true;
        count += grid[x][y];
        int max = 0;
        for (int[] dir : dirs) {
            max = Math.max(max, backtrack(grid, x + dir[0], y + dir[1], visited, count));
        }
        visited[x][y] = false;
//        count -= grid[x][y]; // no use
        return max;
    }

    public int getMaximumGold2(int[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;

        int max = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) continue;
                int count = backtrack(grid, i, j, visited);
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public int backtrack(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= m || y >= n) return 0;
        if (grid[x][y] == 0 || visited[x][y]) return 0;

        visited[x][y] = true;
        int max = 0;
        for (int[] dir : dirs) {
            max = Math.max(max, backtrack(grid, x + dir[0], y + dir[1], visited));
        }
        visited[x][y] = false;
        return grid[x][y] + max;
    }
}
