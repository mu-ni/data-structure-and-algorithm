package algorithm.ArrayAndString;

import java.util.Arrays;

public class MinSizeSubArrSum {

    public int minSubArrayLen(int s, int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        if (sum < s) return 0;

        // 1,2,2,3,3,4
        Arrays.sort(nums);
        int sum = 0;
        for (int i=nums.length -1; i>=0; i--) {
            sum += nums[i];
            if (sum >= s) return nums.length - i;
        }
        return 0;
    }
}
