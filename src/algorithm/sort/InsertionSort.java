package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertion(new int[]{1,4,2,6,9,3,7,8,5})));
    }

    // time complexity O(n^2)
    // space complexity O(1)
    public static int[] insertion(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            int tmp = nums[i];
            while(i >=1 && tmp < nums[i-1]) {
                nums[i] = nums[i-1];
                i--;
            }
            nums[i] = tmp;
        }
        return nums;
    }
}
