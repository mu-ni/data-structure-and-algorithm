package algorithm.RecursionAndDP;

public class WildcardMatching {
    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("acdcb", "a*c?b"));
        System.out.println(new WildcardMatching().isMatch2("acdcb", "a*c?b"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j=1; j<=n; j++) {
            if (dp[0][j-1] && p.charAt(j-1) == '*') {
                dp[0][j] = true;
            }
        }

        for (int i=1; i<=m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int j=1; j<=n; j++) {
            if (dp[j-1] && p.charAt(j-1) == '*') {
                dp[j] = true;
            }
        }

        for (int i=1; i<=m; i++) {
            boolean pre = dp[0];
            for (int j=1; j<=n; j++) {
                boolean tmp = dp[j];
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[j] = pre;
                } else if (p.charAt(j-1) == '*') {
                    dp[j] = dp[j-1] || dp[j];
                } else {
                    dp[j] = false;
                }
                pre = tmp;
            }
            dp[0] = false;
        }

        return dp[n];
    }
}
