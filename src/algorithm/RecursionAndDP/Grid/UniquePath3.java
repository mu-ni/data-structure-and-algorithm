package algorithm.RecursionAndDP.Grid;

/**
 * Created by muni on 2020/9/21
 */
public class UniquePath3 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        System.out.println(new UniquePath3().uniquePathsIII(grid));
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m;
    int n;
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int x = 0;
        int y = 0;
        int empty = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    continue;
                }
                if (grid[i][j] == 0) empty++;
            }
        }
        return dfs(grid, x, y, empty);
    }

    private int dfs(int[][] grid, int x, int y, int empty) {
        if (x < 0 || x >= m || y < 0 || y >= n) return 0;
        if (grid[x][y] == -1) return 0;
        if (grid[x][y] == 2) return empty == 0 ? 1 : 0;

        if (grid[x][y] == 0) empty--; // grid[x][y] == 1 or grid[x][y] == 0
        grid[x][y] = -1;
        int count = 0;
        for (int[] dir : dirs) {
            count += dfs(grid, x + dir[0], y + dir[1], empty);
        }
        grid[x][y] = 0;
//        empty++;
        return count;
    }

}
