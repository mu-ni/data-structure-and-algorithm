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
        int max = 0;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
