package algorithm.RecursionAndDP;

public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("babgbag", "bag"));
        System.out.println(new DistinctSubsequences().numDistinct2("babgbag", "bag"));
    }

    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        if (m > n) return 0;
        int[][] dp = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (t.charAt(i-1) == s.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                    } else {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public int numDistinct2(String s, String t) {
        int m = t.length();
        int n = s.length();
        if (m > n) return 0;
        int[] dp = new int[n+1];

        for (int i=0; i<=m; i++) {
            int pre = 0;
            for (int j=0; j<=n; j++) {
                int tmp = dp[j];
                if (i == 0) {
                    dp[j] = 1;
                } else if (j == 0) {
                    dp[j] = 0;
                } else {
                    if (t.charAt(i-1) == s.charAt(j-1)) {
                        dp[j] = pre + dp[j-1];
                    } else {
                        dp[j] = dp[j-1];
                    }
                }
                pre = tmp;
            }
        }
        return dp[n];
    }
}
