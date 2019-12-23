package algorithm.SearchAndSort;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray2(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray3(new int[]{2}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (start == -1 && nums[i] != sorted[i]) {
                start = i;
            }
            if (start != -1 && nums[i] != sorted[i]) {
                end = i;
            }
        }

        return start == -1 ? 0 : end - start + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int start = 0;
        while (start < nums.length && nums[start] == sorted[start]) {
            start++;
        }
        int end = nums.length - 1;
        while (end >= 0 && nums[end] == sorted[end]) {
            end--;
        }
        return start > end ? 0 : end - start + 1;
    }

    public int findUnsortedSubarray3(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int rst = nums.length;
        int slow = 0;
        while (slow < nums.length && nums[slow] == sorted[slow]) {
            rst--;
            slow++;
        }
        int fast = nums.length-1;
        while (fast >slow && nums[fast] == sorted[fast]) {
            rst--;
            fast--;
        }
        return rst;
    }
}
