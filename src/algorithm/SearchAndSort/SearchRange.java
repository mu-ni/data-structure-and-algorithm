package algorithm.SearchAndSort;

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] < target) {
                start = mid +1;
                continue;
            }
            if (nums[mid] > target) {
                end = mid -1;
                continue;
            }
            return expand(nums, mid);
        }
        return new int[]{-1,-1};
    }

    public int[] expand(int[] nums, int mid) {
        int left = mid;
        int right = mid;
        while(left >=0 && nums[left] == nums[mid]) {
            left--;
        }
        while(right < nums.length && nums[right] == nums[mid]) {
            right++;
        }
        return new int[]{left+1, right-1};
    }
}
