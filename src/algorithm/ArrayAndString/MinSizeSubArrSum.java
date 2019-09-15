package algorithm.ArrayAndString;

import java.util.Arrays;

public class MinSizeSubArrSum {
    public static void main(String[] args) {
        System.out.println(new MinSizeSubArrSum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new MinSizeSubArrSum().minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    // time limited exceed
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                int[] sub = Arrays.copyOfRange(nums, j, i+1);
                if (Arrays.stream(sub).sum() < s) continue;
                min = Math.min(min, i - j + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int pivot = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - pivot + 1);
                sum -= nums[pivot++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
