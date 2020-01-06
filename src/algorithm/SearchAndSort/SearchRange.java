package algorithm.SearchAndSort;

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(new SearchRange().searchRange2(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(new SearchRange().searchRange3(new int[]{5,7,7,8,8,10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int lo = -1;
        int hi = -1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] < target) {
                left = mid+1;
                continue;
            }
            if (nums[mid] > target) {
                right = mid-1;
                continue;
            }
            lo = mid;
            right = mid-1;
        }

        left = 0;
        right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] > target) {
                right = mid-1;
                continue;
            }
            if (nums[mid] < target) {
                left = mid+1;
                continue;
            }
            hi = mid;
            left = mid+1;
        }

        if (lo > hi) return new int[]{-1, -1};

        return new int[]{lo, hi};
    }

    public int[] searchRange2(int[] nums, int target) { //O(n)
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

    public int[] searchRange3(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int[] rst = new int[]{-1, -1};
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] < target) {
                start = mid+1;
            } else if (nums[mid] > target) {
                end = mid-1;
            } else {
                if (mid == 0 || nums[mid-1] < target) {
                    rst[0] = mid;
                    break;
                }
                end = mid-1;
            }
        }
        start = 0;
        end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > target) {
                end = mid-1;
            } else if (nums[mid] < target) {
                start = mid+1;
            } else {
                if (mid == nums.length-1 || nums[mid+1] > target) {
                    rst[1] = mid;
                    break;
                }
                start = mid+1;
            }
        }

        return rst;
    }
}
