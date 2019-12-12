package flag.dp;

/**
 * Created by muni on 2019/12/12
 */
public class PathMinCost {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
        System.out.println(new PathMinCost().minCost(matrix));
    }

    public int minCost(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = matrix[0][0];
        for (int i=1; i<m; i++) {
            dp[i][0] = matrix[i][0] + dp[i-1][0];
        }
        for (int j=1; j<n; j++) {
            dp[0][j] = matrix[0][j] + dp[0][j-1];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
