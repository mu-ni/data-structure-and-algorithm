package algorithm.ArrayAndString;

import java.util.Arrays;

public class IsSubSequence {
    public static void main(String[] args) {
        System.out.println(new IsSubSequence().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubSequence().isSubsequence2("abc", "ahbgdc"));
        System.out.println(new IsSubSequence().isSubsequence3("abc", "ahbgdc"));
    }
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0;
        int indexT = 0;
        while (indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }

    public boolean isSubsequence2(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m+1][n+1];
        Arrays.fill(dp[0], true);

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    // abbc & ahbgdc -> double b -> dp[i-1][j-1]
                    dp[i][j] = dp[i-1][j-1] && dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public boolean isSubsequence3(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp, true);
        dp[0] = false;
        for (int i=1; i<=m; i++) {
            boolean pre = true;
            for (int j=1; j<=n; j++) {
                boolean tmp = dp[j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] = pre && dp[j];
                } else {
                    dp[j] = dp[j-1];
                }
                pre = tmp;
            }
        }
        return dp[n];
    }
}
