package algorithm.ArrayAndString;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {
    public static void main(String[] args) {
        System.out.println(new SubArraySumK().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new SubArraySumK().subarraySum2(new int[]{1, 1, 1}, 2));
        System.out.println(new SubArraySumK().subarraySum3(new int[]{1, 1, 1}, 2));
    }

    // TLE n^3
    public int subarraySum(int[] nums, int k) {
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sum(nums, i, j) == k) {
                    rst++;
                }
            }
        }
        return rst;
    }

    public int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // n^2
    public int subarraySum2(int[] nums, int k) {
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    rst++;
                }
            }
        }
        return rst;
    }

    // n
    public int subarraySum3(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // sum, count
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
