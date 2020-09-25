package algorithm.RecursionAndDP.Grid;

/**
 * Created by muni on 2020/9/25
 */
public class MaxNonNegativeProduct {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1}
        };
        System.out.println(new MaxNonNegativeProduct().maxProductPath(grid));
    }

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (i == 0 && j == 0) {
                    max[i][j] = num;
                    min[i][j] = num;
                    continue;
                }
                if (i == 0) {
                    max[i][j] = Math.max(num * max[i][j - 1], num * min[i][j - 1]);
                    min[i][j] = Math.min(num * max[i][j - 1], num * min[i][j - 1]);
                    continue;
                }
                if (j == 0) {
                    max[i][j] = Math.max(num * max[i - 1][j], num * min[i - 1][j]);
                    min[i][j] = Math.min(num * max[i - 1][j], num * min[i - 1][j]);
                    continue;
                }
                if (num > 0) {
                    max[i][j] = Math.max(num * max[i - 1][j], num * max[i][j - 1]);
                    min[i][j] = Math.min(num * min[i - 1][j], num * min[i][j - 1]);
                }
                if (num < 0) {
                    max[i][j] = Math.max(num * min[i - 1][j], num * min[i][j - 1]);
                    min[i][j] = Math.min(num * max[i - 1][j], num * max[i][j - 1]);
                }
            }
        }
        int mod = (int) (1e9 + 7);
        return max[m - 1][n - 1] < 0 ? -1 : (int) (max[m - 1][n - 1] % mod);
    }
}
