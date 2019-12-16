package flag.dp;

/**
 * Created by muni on 2019/12/12
 */
public class MinEditDistance {
    public static void main(String[] args) {
        System.out.println(new MinEditDistance().minDist("mitcmu", "mtacnu"));
    }

    public int minDist(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i=1; i<=m; i++) {
            dp[i][0] = i;
        }
        for (int j=1; j<=n; j++) {
            dp[0][j] = j;
        }
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                int editDist = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) editDist++;
                dp[i][j] = Math.min(editDist, 1 + Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[m][n];
    }
}
