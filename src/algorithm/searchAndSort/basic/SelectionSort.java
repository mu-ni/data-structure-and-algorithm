package algorithm.searchAndSort.basic;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selection(new int[]{1,4,2,6,9,3,7,8,5})));
    }

    // time complexity O(n^2)
    // space complexity O(1)
    public static int[] selection(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int minIndex = i;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] < nums[minIndex]) {
                   minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }
        return nums;
    }
}
