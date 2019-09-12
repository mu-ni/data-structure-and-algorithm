package algorithm.SearchAndSort;

public class MinInRotatedArray2 {
    public static void main(String[] args) {
        System.out.println(new MinInRotatedArray2().findMin(new int[]{2,2,2,0,1}));
    }

    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int start = 0;
        int end = nums.length-1;
        if (nums[start] < nums[end]) return nums[start];

        while (start < end) {
            int mid = (start + end)/2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }
        return nums[start];
    }
}
