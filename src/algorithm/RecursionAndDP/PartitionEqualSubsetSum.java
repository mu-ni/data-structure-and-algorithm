package algorithm.RecursionAndDP;

import java.util.Arrays;

/**
 * Created by muni on 2020/1/21
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{23,13,11,7,6,5,5}));
        System.out.println(new PartitionEqualSubsetSum().canPartition2(new int[]{23,13,11,7,6,5,5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum%2 == 1) return false;
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                int num = nums[i-1];
                if (j < num) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-num];
                }
            }
        }
        return dp[n][sum];
    }

    public boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum%2 == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int num : nums) {
            for (int i=sum; i>=0; i--) {
                if (i < num) continue;
                dp[i] = dp[i-num] || dp[i];
            }
        }
        return dp[sum];
    }
}
