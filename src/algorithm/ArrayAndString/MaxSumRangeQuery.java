package algorithm.ArrayAndString;

import java.util.Arrays;

/**
 * Created by muni on 2020/9/21
 */
public class MaxSumRangeQuery {
    public static void main(String[] args) {
        System.out.println(new MaxSumRangeQuery().maxSumRangeQuery(new int[]{1,2,3,4,5}, new int[][]{{1,3},{0,1}}));
        System.out.println(new MaxSumRangeQuery().maxSumRangeQuery2(new int[]{1,2,3,4,5}, new int[][]{{1,3},{0,1}}));
    }

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int mod = (int) (1e9 + 7);
        int[] count = new int[n];
        for (int[] req : requests) {
            count[req[0]]++;
            if (req[1] + 1 < n) count[req[1] + 1]--; // reduce time complexity
        }
        for (int i=1; i<n; i++) {
            count[i] += count[i-1];
        }
        Arrays.sort(count);
        Arrays.sort(nums);
        long sum = 0;
        for (int i=0; i<n; i++) {
            sum += (long)(count[i]*nums[i]);
        }
        return (int)(sum % mod);
    }

    // TLE
    public int maxSumRangeQuery2(int[] nums, int[][] requests) {
        int n = nums.length;
        int mod = (int) (1e9 + 7);
        int[] count = new int[n];
        for (int[] req : requests) {
            for (int i=req[0]; i<=req[1]; i++) {
                count[i]++;
            }
        }
        Arrays.sort(count);
        Arrays.sort(nums);
        long sum = 0;
        for (int i=0; i<n; i++) {
            sum += (long)(count[i]*nums[i]);
        }
        return (int)(sum%mod);
    }
}
