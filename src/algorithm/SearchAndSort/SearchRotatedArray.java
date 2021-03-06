package algorithm.SearchAndSort;

public class SearchRotatedArray { //unique element
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search2(new int[]{4,5,6,7,0,1,2}, 0));
    }

    public static int search(int[] arr, int target) { // unique
        if(arr.length == 0) return -1;
        int lo = 0;
        int hi = arr.length-1;
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            if(arr[mid] == target) return mid;
            if(arr[lo] <= arr[mid]) {
                if(target < arr[mid] && target >= arr[lo]) {
                    hi = mid-1;
                }else {
                    lo = mid+1;
                }
            }
            if(arr[mid] <= arr[hi]) {
                if(target > arr[mid] && target <= arr[hi]) {
                    lo = mid+1;
                }else {
                    hi = mid-1;
                }
            }
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    public static int search(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right)/2;
        if (nums[mid] == target) return mid;

        // left part is sorted
        if (nums[left] <= nums[mid]){
            if (nums[left] <= target && target < nums[mid]) {
                return search(nums, left, mid-1, target);
            }
            return search(nums, mid+1, right, target);
        }

        // right part is sorted
        if (nums[mid] < target && target <= nums[right]) {
            return search(nums, mid+1, right, target);
        }
        return search(nums, left, mid-1, target);
    }
}
