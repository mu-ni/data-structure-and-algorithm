package algorithm.RecursionAndDP.OneDimension;

/**
 * Created by muni on 2019/12/19
 */
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{2,1,1,2}));
    }

    public int rob(int[] nums) {
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
