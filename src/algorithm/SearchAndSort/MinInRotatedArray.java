package algorithm.SearchAndSort;

public class MinInRotatedArray {
    public static void main(String[] args) {
        System.out.println(new MinInRotatedArray().findMin(new int[]{3,4,5,1,2}));
        System.out.println(new MinInRotatedArray().findMin2(new int[]{3,4,5,1,2}));
    }

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        if (nums[start] <= nums[end]) return nums[start];

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid+1 <= nums.length-1 && nums[mid+1] < nums[mid]) return nums[mid+1];
            if (mid-1 >= 0 && nums[mid-1] > nums[mid]) return nums[mid];

             if (nums[start] < nums[mid]) {
                 start = mid+1;
             } else {
                 end = mid-1;
             }
//                if (nums[mid] < nums[end]) {
//                    end = mid-1;
//                } else {
//                    start = mid+1;
//                }
        }
        return -1;
    }

    public int findMin2(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
