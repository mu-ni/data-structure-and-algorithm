package algorithm.ArrayAndString;

import java.util.Arrays;

public class KthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    // O(nlogn)
    // O(1)
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //TODO partition
}
