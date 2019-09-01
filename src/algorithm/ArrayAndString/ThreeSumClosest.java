package algorithm.ArrayAndString;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, -1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int rst = nums[0] + nums[1] + nums[2];
        for (int i=0; i<nums.length; i++) {
            int left = i+1;
            int right = nums.length -1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(rst - target)) {
                    rst = sum;
                    continue;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return rst;
    }
}
