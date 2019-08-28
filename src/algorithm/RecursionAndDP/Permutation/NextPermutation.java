package algorithm.RecursionAndDP.Permutation;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,5,3,2};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int pivot = nums.length-2;
        while(pivot >= 0 && nums[pivot] >= nums[pivot+1]) {
            pivot--;
        }
        if (pivot == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        int index = nums.length-1;
        while (nums[index] <= nums[pivot]) {
            index--;
        }
        swap(nums, pivot, index);
        reverse(nums, pivot+1, nums.length-1);
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
