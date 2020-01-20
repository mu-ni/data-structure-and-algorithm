package algorithm.RecursionAndDP;

/**
 * Created by muni on 2020/1/20
 */
public class MinFallingPathSum {

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(new MinFallingPathSum().minFallingPathSum(A));
        System.out.println(new MinFallingPathSum().minFallingPathSum2(A));
    }

    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];
        for (int j=0; j<n; j++) {
            dp[0][j] = A[0][j];
        }
        for (int i=1; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (j == 0 && j == n-1) {
                    dp[i][j] = A[i][j] + dp[i-1][j];
                } else if (j == 0) {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == n-1) {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                } else {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j+1], dp[i-1][j-1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j=0; j<n; j++) {
            min = Math.min(min, dp[m-1][j]);
        }
        return min;
    }


    public int minFallingPathSum2(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = A.clone();
        for (int i=1; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (j == 0 && j == n-1) {
                    dp[i][j] += dp[i-1][j];
                } else if (j == 0) {
                    dp[i][j] += Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == n-1) {
                    dp[i][j] += Math.min(dp[i-1][j], dp[i-1][j-1]);
                } else {
                    dp[i][j] += Math.min(dp[i-1][j], Math.min(dp[i-1][j+1], dp[i-1][j-1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j=0; j<n; j++) {
            min = Math.min(min, dp[m-1][j]);
        }
        return min;
    }
}
