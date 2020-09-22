package algorithm.ArrayAndString.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {
    public static void main(String[] args) {
        System.out.println(new ContinuousSubArraySum().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(new ContinuousSubArraySum().checkSubarraySum2(new int[]{23, 2, 6, 4, 7}, 6));
    }

    // at least 2 items in subarray
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i=0; i<nums.length; i++) {
            int sum =nums[i];
            for (int j=i+1; j<nums.length; j++) {
                sum += nums[j];
                if ((k == 0 && sum == 0) || (k != 0 && sum % k == 0)) return true;
            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            if (!map.containsKey(sum)) {
                map.put(sum, i);
                continue;
            }
            if (i - map.get(sum) > 1) return true;
        }
        return false;
    }
}
