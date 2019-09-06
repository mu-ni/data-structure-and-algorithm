package algorithm.ArrayAndString;

import java.util.Arrays;

public class RemoveDuplicates {
    // array is sorted
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, i)));

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        i = new RemoveDuplicates().removeDuplicates2(nums);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, i)));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast++];
                continue;
            }
            fast++;
        }
        return slow+1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int index = 0;
        for (int n : nums) {
            if (index < 1 || nums[index-1] < n) {
                nums[index++] = n;
            }
        }
        return index;
    }
}
