package algorithm.RecursionAndDP;

public class MaximalSquare {
    public static void main(String[] args) {
        MaximalSquare obj = new MaximalSquare();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(obj.maximalSquare(matrix));
        System.out.println(obj.maximalSquare2(matrix));
        System.out.println(obj.maximalSquare3(matrix));
        System.out.println(obj.maximalSquare4(matrix));
        System.out.println(obj.maximalSquare5(matrix));
    }

    public int maximalSquare(char[][] matrix) { // return max area
        if (matrix.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '1') continue;
                max = Math.max(max, 1);
                loop:
                for (int l = 1; l + i < matrix.length && l + j < matrix[0].length; l++) {
                    if (!isSquare(matrix, i, j, l)) {
                        break loop;
                    }
                    max = Math.max(max, (l + 1) * (l + 1));
                }
            }
        }
        return max;
    }

    public boolean isSquare(char[][] matrix, int x, int y, int len) {
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                if (matrix[x + i][y + j] != '1') return false;
            }
        }
        return true;
    }

    // O(mn)
    // O(mn)
    public int maximalSquare2(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    // O(mn)
    // O(n)
    public int maximalSquare3(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] dp = new int[matrix[0].length + 1];
        int max = 0;
        int prev = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                int tmp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = tmp;
            }
        }
        return max * max;
    }

    public int maximalSquare4(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') continue;
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    max = Math.max(max, 1);
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }

    public int maximalSquare5(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        int[] dp = new int[n];
        int max = 0;
        int pre = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = dp[j];
                if (matrix[i][j] == '0') {
                    dp[j] = 0;
                    pre = tmp;
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = Math.min(pre, Math.min(dp[j], dp[j - 1])) + 1;
                }
                max = Math.max(max, dp[j]);
                pre = tmp;
            }
        }

        return max * max;
    }
}
