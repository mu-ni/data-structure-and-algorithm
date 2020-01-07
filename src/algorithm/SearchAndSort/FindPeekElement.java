package algorithm.SearchAndSort;

public class FindPeekElement {
    public static void main(String[] args) {
        System.out.println(new FindPeekElement().findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(new FindPeekElement().findPeakElement2(new int[]{1,2,1,3,5,6,4}));
        System.out.println(new FindPeekElement().findPeakElement3(new int[]{1,2,1,3,5,6,4}));
        // output 1 or 5
    }

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid == nums.length - 1) return mid;
            if (nums[mid] < nums[mid+1]) {
                start = mid+1;
            } else {
                if (mid == 0 || nums[mid] >= nums[mid-1]) return mid;
                end = mid-1;
            }
        }
        return -1;
    }

    public int findPeakElement2(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (start == end) return mid;
            if (mid != end && nums[mid] > nums[mid+1]) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public int findPeakElement3(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (start == end) return mid;
            if (mid != end && nums[mid] > nums[mid+1]) {
                if (mid == start || nums[mid] > nums[mid-1]) return mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}
