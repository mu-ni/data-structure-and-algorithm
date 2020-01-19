package algorithm.RecursionAndDP;

/**
 * Created by muni on 2020/1/19
 */
public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        System.out.println(new GreatestSumDivisibleByThree().maxSumDivThree(new int[]{3,6,5,1,8}));
        System.out.println(new GreatestSumDivisibleByThree().maxSumDivThree2(new int[]{3,6,5,1,8}));
    }

    // not really understand
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int n : nums) {
            int[] dp2 = new int[3];
            for (int i=0; i<3; i++) {
                int rem = (i + n)%3;
                dp2[rem] = Math.max(dp[rem], dp[i] + n);
            }
            dp = dp2;
        }
        return dp[0];
    }

    // not really understand
    public int maxSumDivThree2(int[] nums) {
        int sum = 0;
        int rem1 = 20000;
        int rem2 = 20000;
        for (int n : nums) {
            sum += n;
            if (n%3 == 1) {
                rem2 = Math.min(rem2, rem1 + n);
                rem1 = Math.min(rem1, n);
            }
            if (n%3 == 2) {
                rem1 = Math.min(rem1, rem2 + n);
                rem2 = Math.min(rem2, n);
            }
        }

        if (sum%3 == 1) return sum - rem1;
        if (sum%3 == 2) return sum - rem2;
        return sum;
    }
}
