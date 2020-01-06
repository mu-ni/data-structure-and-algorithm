package algorithm.RecursionAndDP;

public class MinDistance {
    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
        System.out.println(new MinDistance().minDistance2("dinitrophenylhydrazine", "acetylphenylhydrazine"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                int replDistance = word1.charAt(i-1) == word2.charAt(j-1) ? dp[i-1][j-1] : dp[i-1][j-1]+1;
                int editDistance = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                dp[i][j] = Math.min(editDistance, replDistance);
            }
        }
        return dp[m][n];
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n+1];
        for (int i=0; i<=m; i++) {
            int pre = 0;
            for (int j=0; j<=n; j++) {
                int tmp = dp[j];
                if (i == 0) {
                    dp[j] = j;
                } else if (j == 0) {
                    dp[j] = i;
                } else {
                    int replDistance = word1.charAt(i-1) == word2.charAt(j-1) ? pre : pre+1;
                    int editDistance = Math.min(dp[j], dp[j-1]) + 1;
                    dp[j] = Math.min(editDistance, replDistance);
                }
                pre = tmp;
            }
        }
        return dp[n];
    }
}
