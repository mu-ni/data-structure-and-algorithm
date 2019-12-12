package flag.dp;

/**
 * Created by muni on 2019/12/12
 */
public class LongestCommonSubstr {
    public static void main(String[] args) {
        System.out.println(new LongestCommonSubstr().maxLen("BDCABA", "ABCBDAB"));
    }

    public int maxLen(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i=1; i<m; i++) {
            dp[i][0] = 0;
        }
        for (int j=1; j<n; j++) {
            dp[0][j] = 0;
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                char c = s.charAt(i-1);
                char d = t.charAt(j-1);
                int len = dp[i-1][j-1];
                if (c == d) {
                    len++;
                }
                dp[i][j] = Math.max(len, Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }

        return dp[m][n];
    }
}
