package algorithm.RecursionAndDP;

/**
 * Created by muni on 2019/12/27
 */
public class CountSquareSubmatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(new CountSquareSubmatrix().countSquares(matrix));
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];

        int count = 0;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (matrix[i-1][j-1] == 0) continue;
                dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                count += dp[i][j];
            }
        }
        return count;
    }
}
