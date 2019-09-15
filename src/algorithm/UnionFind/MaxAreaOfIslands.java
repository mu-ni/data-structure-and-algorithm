package algorithm.UnionFind;

public class MaxAreaOfIslands {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        System.out.println(new MaxAreaOfIslands().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        if (m == 0) return max;
        int n = grid[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return 0;
        if (grid[x][y] != 1) return 0;

        grid[x][y] = 0;
        return 1 +
                dfs(grid, x+1, y) +
                dfs(grid, x-1, y) +
                dfs(grid, x, y+1) +
                dfs(grid, x, y-1);
    }
}
