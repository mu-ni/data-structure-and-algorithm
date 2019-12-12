package flag.dp;

/**
 * Created by muni on 2019/12/12
 */
public class MinEditDistance {
    public static void main(String[] args) {
        System.out.println(new MinEditDistance().minDist("mitcmu", "mtacnu"));
    }

    public int minDist(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i=1; i<m; i++) {
            dp[i][0] = 1;
        }
        for (int j=1; j<n; j++) {
            dp[0][j] = 1;
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                char c = s.charAt(i-1);
                char d = t.charAt(j-1);

                int replaceDist = dp[i-1][j-1];
                if (c != d) replaceDist++;
                int editDist = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                dp[i][j] = Math.min(replaceDist, editDist);
            }
        }
        return dp[m][n];
    }
}
