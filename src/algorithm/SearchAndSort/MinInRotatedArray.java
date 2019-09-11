package algorithm.SearchAndSort;

public class MinInRotatedArray {
    public static void main(String[] args) {
        System.out.println(new MinInRotatedArray().findMin(new int[]{3,4,5,1,2}));
        System.out.println(new MinInRotatedArray().findMin2(new int[]{3,4,5,1,2}));
    }

    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int start = 0;
        int end = nums.length-1;
        if (nums[start] < nums[end]) return nums[start];

        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] > nums[mid+1]) return nums[mid+1];
            if (nums[mid] < nums[mid-1]) return nums[mid];

            if (nums[start] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

    public int findMin2(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int mid = (start + end)/2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid+1;
            }
        }
        return nums[start];
    }
}
