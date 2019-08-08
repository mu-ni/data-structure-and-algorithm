package algorithm.SearchAndSort.basic;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shell(new int[]{1,4,2,6,9,3,7,8,5})));
    }

    // time complexity O(n^2)
    // space complexity O(1)
    public static int[] shell(int[] nums) {
        for(int gap = nums.length/2; gap>0; gap /= 2) {
            for (int i = gap; i < nums.length; i += 1) {
                insertI(nums, gap, i);
            }
        }
        return nums;
    }

    public static void insertI(int[] nums, int gap, int i) {
        int tmp = nums[i];
        while (i >= gap && nums[i - gap] > tmp) {
            nums[i] = nums[i - gap];
            i -= gap;
        }
        nums[i] = tmp;
    }
}
