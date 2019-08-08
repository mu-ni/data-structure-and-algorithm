package algorithm.searchAndSort;

public class SearchRotatedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search2(new int[]{2,5,6,0,0,1,2}, 0));
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

    public static boolean search2(int[] arr, int target) { // duplicated
        if(arr.length == 0) return false;
        int lo = 0;
        int hi = arr.length-1;
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            if(arr[mid] == target) return true;

            while (arr[lo] == arr[mid] && lo != mid) {
                lo ++;
            }
            while (arr[mid] == arr[hi] && mid != hi) {
                hi --;
            }

            if(arr[lo] <= arr[mid]) {
                if(target < arr[mid] && target >= arr[lo]) {
                    hi = mid;
                }else {
                    lo = mid+1;
                }
            } else if(arr[mid] <= arr[hi]) {
                if(target > arr[mid] && target <= arr[hi]) {
                    lo = mid+1;
                }else {
                    hi = mid;
                }
            }
        }
        return false;
    }
}
