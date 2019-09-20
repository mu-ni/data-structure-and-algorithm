package algorithm.RecursionAndDP;

public class MinDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
        System.out.println(minDistance3("dinitrophenylhydrazine", "acetylphenylhydrazine"));
    }

    public static int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        if (l1 == 0 && l2 == 0) return 0;
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;

        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                int replaceDistance = dp[i - 1][j - 1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) replaceDistance++;
                int editDistance = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                dp[i][j] = Math.min(replaceDistance, editDistance);
            }
        }
        return dp[l1][l2];
    }

    public static int minDistance2(String word1, String word2) { // time limited
        if (word1.length() == 0 && word2.length() == 0) return 0;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        int a = minDistance(word1, word2.substring(0, word2.length() - 1)) + 1;
        int b = minDistance(word1.substring(0, word1.length() - 1), word2) + 1;
        int c = minDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
        if (word1.charAt(word1.length() - 1) != word2.charAt(word2.length() - 1)) c++;

        return Math.min(Math.min(a, b), c);
    }

    public static int minDistance3(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        if (l1 == 0 && l2 == 0) return 0;
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;

        int[] dp = new int[l2 + 1];
        for (int i = 0; i <= l1; i++) {
            int pre = 0;
            for (int j = 0; j <= l2; j++) {
                int tmp = dp[j];
                if (i == 0) {
                    dp[j] = j;
                } else if (j == 0) {
                    dp[j] = i;
                } else {
                    int replaceDistance = pre;
                    if (word1.charAt(i-1) != word2.charAt(j-1)) replaceDistance++;
                    int editDistance = Math.min(dp[j], dp[j - 1]) + 1;
                    dp[j] = Math.min(replaceDistance, editDistance);
                }
                pre = tmp;
            }
        }
        return dp[l2];
    }
}
