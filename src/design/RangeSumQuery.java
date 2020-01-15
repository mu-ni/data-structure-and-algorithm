package design;

/**
 * Created by muni on 2020/1/15
 */
public class RangeSumQuery {
    int[] dp;
    public RangeSumQuery(int[] nums) {
        int n = nums.length;
        dp = nums.clone();
        for (int i=1; i<n; i++) {
            dp[i] += dp[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return dp[j];
        return dp[j] - dp[i-1];
    }

    public static void main(String[] args) {
        RangeSumQuery rsq = new RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(rsq.sumRange(0,2));
        System.out.println(rsq.sumRange(2,5));
        System.out.println(rsq.sumRange(0,5));
    }
}
