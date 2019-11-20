package algorithm.UnionFind;

public class NumberOfClosedIslands {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(new NumberOfClosedIslands().closedIsland(grid));
    }

    // 0 land, 1 water
    int m;
    int n;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i=0; i<m; i++) {
            if (grid[i][0] == 0) dfs(grid, i, 0);
            if (grid[i][n-1] == 0) dfs(grid, i, n-1);
        }
        for (int j=0; j<n; j++) {
            if (grid[0][j] == 0) dfs(grid, 0, j);
            if (grid[m-1][j] == 0) dfs(grid, m-1, j);
        }

        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) continue;
                dfs(grid, i, j);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (grid[x][y] == 1) return;
        grid[x][y] = 1;
        for (int[] dir : dirs) {
            dfs(grid, x + dir[0], y + dir[1]);
        }
    }
}
