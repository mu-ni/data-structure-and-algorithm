package design;

/**
 * Created by muni on 2020/1/15
 */
public class RangeSumQuery2 {
    int[][] dp;

    public RangeSumQuery2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for (int j=1; j<n; j++) {
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = matrix[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) return dp[row2][col2];
        if (row1 == 0) return dp[row2][col2] - dp[row2][col1-1];
        if (col1 == 0) return dp[row2][col2] - dp[row1 - 1][col2];
        return dp[row2][col2] - dp[row2][col1-1] - dp[row1-1][col2] + dp[row1-1][col1-1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        RangeSumQuery2 rsq = new RangeSumQuery2(matrix);
        System.out.println(rsq.sumRegion(2, 1, 4, 3));
        System.out.println(rsq.sumRegion(1, 1, 2, 2));
        System.out.println(rsq.sumRegion(1, 2, 2, 4));
    }
}
