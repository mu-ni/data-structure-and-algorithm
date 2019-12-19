package algorithm.RecursionAndDP;

import java.util.Arrays;

/**
 * Created by muni on 2019/12/19
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        System.out.println(new HouseRobber2().rob(new int[]{1,2,3,1}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // {1,2,3,1} -> {1,2,3} & {2,3,1}
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }

    public int rob(int[] nums, int start, int end) {
        nums = Arrays.copyOfRange(nums, start, end+1);
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i < 2) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(nums[i] + dp[i-2], nums[i] + dp[i-1] - nums[i-1]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
