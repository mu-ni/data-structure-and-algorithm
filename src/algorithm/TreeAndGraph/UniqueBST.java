package algorithm.TreeAndGraph;

public class UniqueBST {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
        System.out.println(numTrees2(3));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static int numTrees2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = helper(i, dp);
        }

        return dp[n];
    }

    public static int helper(int n, int[] dp) {
        for (int i=1; i<=n; i++) {
            dp[n] += dp[i-1] * dp[n-i];
        }
        return dp[n];
    }
}
