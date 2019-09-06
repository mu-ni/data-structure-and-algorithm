package algorithm.RecursionAndDP;

public class Multiply {
    public static void main(String[] args) {
        System.out.println(multiply(123, 456));
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        int[] dp = new int[num1.length() + num2.length()];
        for (int i=num1.length()-1; i>=0; i--) {
            for(int j=num2.length()-1;j>=0;j--) {
                int n1 = num1.charAt(i)-'0';
                int n2 = num2.charAt(j)-'0';
                int sum = n1*n2 + dp[i+j+1];

                dp[i+j+1] = sum%10;
                dp[i+j] += sum/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : dp) {
            if (sb.length() == 0 && i == 0) continue;
            sb.append(i);
        }
        return sb.length() == 0 ? "0":sb.toString();
    }

    public static int multiply(int num1, int num2) {
        int smaller = Math.min(num1, num2);
        int bigger = Math.max(num1, num2);
        return helper(smaller, bigger);
    }

    public static int helper(int smaller, int bigger) {
        if (smaller == 0) return 0;
        if (smaller == 1) return bigger;

        int half = smaller/2;
        if (smaller%2 == 1) {
            return helper(half, bigger) + helper(half+1, bigger);
        }
        return helper(half, bigger) + helper(half, bigger);
    }
}
