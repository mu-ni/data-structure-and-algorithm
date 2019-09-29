package algorithm.SearchAndSort;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (i >= start && i <= end) {
            if (nums[i] == 2) {
                swap(nums, i, end);
                end--;
                continue;
            }
            if (nums[i] == 0) {
                swap(nums, i, start);
                start++;
            }
            i++;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
