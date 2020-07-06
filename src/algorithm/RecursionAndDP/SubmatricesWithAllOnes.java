package algorithm.RecursionAndDP;

public class SubmatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0,1,1,0},
                {0,1,1,1},
                {1,1,1,0}
        };
        System.out.println(new SubmatricesWithAllOnes().numSubmat(mat));
    }

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) continue;
                dp[i][j] = (i > 0 ? dp[i-1][j] : 0) + 1;
                int min = dp[i][j];
                for (int k=j; k>=0; k--) {
                    min = Math.min(min, dp[i][k]);
                    count += min;
                }
            }
        }
        return count;
    }
}
