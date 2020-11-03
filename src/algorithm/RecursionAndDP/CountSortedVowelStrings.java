package algorithm.RecursionAndDP;

/**
 * Created by muni on 2020/11/3
 */
public class CountSortedVowelStrings {
    public static void main(String[] args) {
        System.out.println(new CountSortedVowelStrings().countVowelStrings(5));
        System.out.println(new CountSortedVowelStrings().countVowelStrings2(5));
        System.out.println(new CountSortedVowelStrings().countVowelStrings3(5));
    }

    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        for (int i=0; i<n; i++) {
            for (int j=0; j<5; j++) {
                if (i == 0 && j == 0 || j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n-1][4];
    }

    public int countVowelStrings2(int n) {
        int[][] dp = new int[n+1][6];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=5; j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j-1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n][5];
    }

    public int countVowelStrings3(int n) {
        int[] dp = new int[6];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=5; j++) {
                if (i == 1) {
                    dp[j] = dp[j-1] + 1;
                } else {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[5];
    }
}
