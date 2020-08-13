package algorithm.RecursionAndDP;

import java.util.HashMap;
import java.util.Map;

public class NonOverlappingSubarraysWithSum {
    public static void main(String[] args) {
        System.out.println(new NonOverlappingSubarraysWithSum().maxNonOverlapping(new int[]{-1,3,5,1,4,2,-9}, 6));
        System.out.println(new NonOverlappingSubarraysWithSum().maxNonOverlapping2(new int[]{-1,3,5,1,4,2,-9}, 6));
    }

    // prefix
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        int rst = 0;
        for (int n : nums) {
            sum += n;
            if (map.containsKey(sum - target)) {
                rst = Math.max(rst, map.get(sum - target)+1);
            }
            map.put(sum, rst);
        }
        return rst;
    }

    public int maxNonOverlapping2(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n+1];
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j>=0; j--) {
                sum += nums[j];
                int add = sum == target ? 1 : 0;
                dp[i+1] = Math.max(dp[i+1], dp[j] + add);
            }
        }
        return dp[n];
    }
}
