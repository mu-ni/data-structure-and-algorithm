package algorithm.TreeAndGraph;

public class UniqueBST {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
        System.out.println(numTrees2(3));
    }

    // f(3) =
    // G(1,3) + G(2,3) + G(3,3) =
    // f(1-1)*f(3-1) + f(2-1)*f(3-2) + f(3-1)*f(3-3)
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }

        return dp[n];
    }

    public static int numTrees2(int n) {
        if (n <= 1) return 1;
        int sum = 0;
        for (int i=1; i<=n; i++) {
            sum += numTrees2(i-1)*numTrees2(n-i);
        }
        return sum;
    }
}
