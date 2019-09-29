package algorithm.RecursionAndDP;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("23421"));
    }

    public int numDecodings(String s) {
        int m = s.length();
        if (m == 0) return 0;
        int[] dp = new int[m];
        dp[0] = s.charAt(0) == '0' ? 0:1;
        for (int i=1; i<s.length(); i++) {
            int n1 = s.charAt(i) - '0';
            int n2 = (s.charAt(i-1) - '0')*10 + n1;

            if (1 <= n1 && n1 <= 9) {
                dp[i] = dp[i-1];
            }
            if (10 <= n2 && n2 <= 26) {
                dp[i] += i >= 2 ? dp[i-2] : 1;
            }
        }
        return dp[m-1];
    }
}
