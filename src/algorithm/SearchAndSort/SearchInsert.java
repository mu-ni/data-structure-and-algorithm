package algorithm.SearchAndSort;

public class SearchInsert {
    public static void main(String[] args) {
        System.out.println(new SearchInsert().searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(new SearchInsert().searchInsert2(new int[]{1,3,5,6}, 7));
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }

    public int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid-1] < target) return mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return nums.length;
    }
}
