package algorithm.SearchAndSort;

public class SearchRotatedArray2 { //duplicated element
    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(search2(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
    }

    public static boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return true;

            // skip duplicated
            while (nums[lo] == nums[mid] && lo != mid) {
                lo++;
            }
            while (nums[mid] == nums[hi] && mid != hi) {
                hi--;
            }

            // nums[lo] == nums[mid] -> lo == mid
            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            if (nums[mid] <= nums[hi]) {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }

    public static boolean search2(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public static boolean search(int[] nums, int left, int right, int target) {
        if (left > right) return false;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return true;

        // skip duplicated
        while (nums[left] == nums[mid] && left != mid) {
            left++;
        }
        while (nums[right] == nums[mid] && right != mid) {
            right--;
        }

        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return search(nums, left, mid - 1, target);
            }
            return search(nums, mid + 1, right, target);
        }

        if (nums[mid] < target && target <= nums[right]) {
            return search(nums, mid + 1, right, target);
        }
        return search(nums, left, mid - 1, target);
    }
}
