package algorithm.RecursionAndDP.OneDimension;

import java.util.Arrays;

public class LongestIncreasingSubarrCount {
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubarrCount().findNumberOfLIS(new int[]{2,2,2,2,2}));
    }

    // don't understand
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int[] len = new int[n + 1];
        int[] cnt = new int[n + 1];
        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(len[j] + 1 < len[i])
                    continue;
                if(i != n && nums[i] <= nums[j])
                    continue;

                if(len[j] + 1 > len[i])
                    cnt[i] = 0;
                len[i] = len[j] + 1;
                cnt[i] += cnt[j];
            }
        }
        return cnt[n];
    }
}
