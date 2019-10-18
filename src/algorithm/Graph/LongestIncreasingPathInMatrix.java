package algorithm.Graph;

public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
        System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath(matrix));
        System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath2(matrix));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // TLE
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return 0;
        n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, Integer.MIN_VALUE, 0);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int x, int y, int val, int len) {
        if (x < 0 || y < 0 || x >= m || y >= n) return len;
        if (matrix[x][y] <= val) return len;
        int max = len;
        for (int[] dir : dirs) {
            max = Math.max(max, dfs(matrix, x + dir[0], y + dir[1], matrix[x][y], len + 1));
        }
        return max;
    }

    public int longestIncreasingPath2(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return 0;
        n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, Integer.MIN_VALUE, dp);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int x, int y, int val, int[][] dp) {
        if (x < 0 || y < 0 || x >= m || y >= n) return 0;
        if (matrix[x][y] <= val) return 0;
        if (dp[x][y] != 0) return dp[x][y];

        int max = 0;
        for (int[] dir : dirs) {
            max = Math.max(max, 1 + dfs(matrix, x + dir[0], y + dir[1], matrix[x][y], dp));
        }
        dp[x][y] = max;
        return max;
    }
}