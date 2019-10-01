package algorithm.RecursionAndDP;

public class MaxProductSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct2(new int[]{2,3,-2,4}));
        System.out.println(maxProduct3(new int[]{2,3,-2,4}));
    }

    public static int maxProduct(int[] nums) { // brute force
        int rst = nums[0];
        for (int i=0; i<nums.length; i++) {
            int pro = nums[i];
            int max = nums[i];
            for (int j=i+1; j<nums.length; j++) {
                pro *= nums[j];
                max = Math.max(max, pro);
            }
            rst = Math.max(max, rst);
        }
        return rst;
    }

    public static int maxProduct2(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0]; // min
        dp[0][1] = nums[0]; // max
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp[i][0] = Math.min(Math.min(dp[i-1][0]*nums[i], dp[i-1][1]*nums[i]), nums[i]);
            dp[i][1] = Math.max(Math.max(dp[i-1][0]*nums[i], dp[i-1][1]*nums[i]), nums[i]);
            max = Math.max(dp[i][1], max);
        }
        return max;
    }

    public static int maxProduct3(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        int rst = nums[0];
        for (int i=1; i<nums.length; i++) {
            min[i] = Math.min(Math.min(min[i-1]*nums[i], max[i-1]*nums[i]), nums[i]);
            max[i] = Math.max(Math.max(min[i-1]*nums[i], max[i-1]*nums[i]), nums[i]);
            rst = Math.max(max[i], rst);
        }
        return rst;
    }
}
