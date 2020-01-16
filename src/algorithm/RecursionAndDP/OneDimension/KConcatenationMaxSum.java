package algorithm.RecursionAndDP.OneDimension;

/**
 * Created by muni on 2020/1/16
 */
public class KConcatenationMaxSum {
    public static void main(String[] args) {
        System.out.println(new KConcatenationMaxSum().kConcatenationMaxSum(new int[]{1,2}, 3));
    }

    //MLE
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        int[] nums = new int[n*k];
        for (int i=0; i<n*k; i++) {
            nums[i] = arr[i%n];
        }
        int[] dp = new int[n*k];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i=1; i<n*k; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
