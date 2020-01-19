package algorithm.DFS;

import java.util.Arrays;

/**
 * Created by muni on 2020/1/19
 */
public class TargetSum {
    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        System.out.println(new TargetSum().findTargetSumWays2(new int[]{1,1,1,1,1}, 3));
    }

    int count = 0;
    int S = 0;
    public int findTargetSumWays(int[] nums, int S) {
        this.S = S;
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int i, int sum) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
            return;
        }
        dfs(nums, i+1, sum + nums[i]);
        dfs(nums, i+1, sum - nums[i]);
    }


    // not really understand
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if (S < -sum || S > sum) return 0;

        int n = nums.length;
        int[][] dp = new int[n+1][sum*2+1];
        dp[0][sum] = 1;
        int min = 0;
        int max = sum*2;
        for (int i=1; i<=n; i++) {
            for (int j=min; j<=max; j++) {
                int num = nums[i-1];
                if (j + num <= max) {
                    dp[i][j] += dp[i-1][j+num];
                }
                if (j - num >= min) {
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }

        return dp[n][S + sum];
    }
}
