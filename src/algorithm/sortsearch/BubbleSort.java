package algorithm.sortsearch;

import java.util.Arrays;

/**
 * Created by muni on 2019/8/5
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,2,6,9,3,7,8,5};
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }

    // time complexity O(n^2)
    // space complexity O(1)
    public static int[] bubble(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }
}
