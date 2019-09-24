package algorithm.RecursionAndDP;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    continue;
                }
                if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }

        int max = 0;
        for (int[] a : dp) {
            int area = new MaximalRectangleHistogram().largestRectangleArea2(a);
            max=Math.max(area, max);
        }

        return max;
    }
}
