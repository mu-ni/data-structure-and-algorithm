package algorithm.ArrayAndString;

import java.util.Arrays;

public class RemoveDuplicates2 {
    // array is sorted
    // at most twice
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = new RemoveDuplicates2().removeDuplicates(nums, 2);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, i)));

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        i = new RemoveDuplicates2().removeDuplicates2(nums, 2);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, i)));

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        i = new RemoveDuplicates2().removeDuplicates3(nums, 2);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, i)));
    }

    public int removeDuplicates(int[] nums, int max) {
        if (nums.length <= 1) return nums.length;

        int slow = 0;
        int fast = 1;
        int count = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast++];
                count = 1;
                continue;
            }
            if (count < max) {
                nums[++slow] = nums[fast++];
                count++;
                continue;
            }
            fast++;
        }

        return slow+1;
    }

    public int removeDuplicates2(int[] nums, int max) {
        if (nums.length <= max) return nums.length;

        int index = 0;
        for (int n : nums) {
            if (index < max || nums[index-max] != n) {
                nums[index++] = n;
            }
        }
        return index;
    }

    public int removeDuplicates3(int[] nums, int max) {
        if (nums.length <= max) return nums.length;
        int i = 0;
        for (int n : nums) {
            if (i >= max && nums[i - max] == n) continue;
            nums[i++] = n;
        }
        return i;
    }
}
