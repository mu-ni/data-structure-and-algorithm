package algorithm.RecursionAndDP.OneDimension;

import java.util.Arrays;

/**
 * Created by muni on 2019/12/12
 */
public class LongestIncreasingSubarr {
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubarr().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new LongestIncreasingSubarr().lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18}));
    }

    // continuous not necessary
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            max=Math.max(max, dp[i]);
        }
        return max;
    }

    // binary search ???
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
