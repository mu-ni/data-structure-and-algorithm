package algorithm.RecursionAndDP.OneDimension;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("22623"));
        System.out.println(new DecodeWays().numDecodings2("22623"));
        System.out.println(new DecodeWays().numDecodings3("22623"));
    }

    public int numDecodings(String s) {
        int m = s.length();
        if (m == 0) return 0;
        int[] dp = new int[m];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int n1 = s.charAt(i) - '0';
            int n2 = (s.charAt(i - 1) - '0') * 10 + n1;

            if (1 <= n1 && n1 <= 9) {
                dp[i] = dp[i - 1];
            }
            if (10 <= n2 && n2 <= 26) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }
        return dp[m - 1];
    }

    public int numDecodings2(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            int n1 = Integer.parseInt(s.substring(i, i + 2));
            if (n1 <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }

    public int numDecodings3(String s) {
        if (s.length() == 0) return 0;

        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i=1; i<s.length(); i++) {
            int cur = Integer.valueOf(s.substring(i, i+1));
            int prev = Integer.valueOf(s.substring(i-1, i+1));

            if (1 <= cur && cur <= 9) {
                dp[i] = dp[i-1];
            }
            if (10 <= prev && prev <= 26) {
                if (i < 2) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length()-1];
    }
}
