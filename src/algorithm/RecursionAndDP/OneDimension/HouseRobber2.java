package algorithm.RecursionAndDP.OneDimension;

import java.util.Arrays;

/**
 * Created by muni on 2019/12/19
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        System.out.println(new HouseRobber2().rob(new int[]{1,2,1,1}));
        System.out.println(new HouseRobber2().rob2(new int[]{1,2,1,1}));
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

    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int rob1 = rob2(nums, 0, nums.length-2);
        int rob2 = rob2(nums, 1, nums.length-1);
        return Math.max(rob1, rob2);
    }

    public int rob2(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        int index = 0;
        int max = 0;
        for (int i=start; i<=end; i++) {
            if (i < start + 2) {
                dp[index] = nums[i];
            } else {
                dp[index] = Math.max(nums[i] + dp[i-2-start], nums[i] + dp[i-1-start] - nums[i-1]);
            }
            max = Math.max(max, dp[index]);
            index++;
        }
        return max;
    }
}
