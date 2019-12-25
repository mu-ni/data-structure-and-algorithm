package algorithm.TwoPointers.LongestSubstring;

public class CommonSubSequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("abcde", "ace"));
        System.out.println(longestCommonSubSequence2("abcde", "ace"));
        System.out.println(longestCommonSubSequence3("abcde", "ace"));
    }

    public static int longestCommonSubSequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if (i == 0 && j == 0) {
                    if (c1 == c2) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                    continue;
                }
                if (i == 0) {
                    if (c1 == c2) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                    continue;
                }
                if (j == 0) {
                    if (c1 == c2) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    continue;
                }
                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int longestCommonSubSequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    // abc & acc
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static int longestCommonSubSequence3(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int pre = 0;
            for (int j = 1; j <= n; j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                int tmp = dp[j];
                if (c1 == c2) {
                    dp[j] = 1 + pre;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = tmp;
            }
        }
        return dp[n];
    }
}
