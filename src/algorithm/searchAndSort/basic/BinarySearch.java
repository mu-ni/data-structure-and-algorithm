package algorithm.searchAndSort.basic;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7,8,9}, 3));
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7,8,9}, 13));
    }

//    public static int binarySearch(int[] arr, int target) {
//        int low = 0;
//        int high = arr.length-1;
//        int mid;
//
//        while(low < high) {
//            mid = (low + high)/2;
//            if(arr[mid] < target) {
//                low = mid+1;
//            } else if (arr[mid] > target) {
//                high = mid-1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }

    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length-1, target);
    }

    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = (low+high)/2;
        if(arr[mid] < target) {
            return binarySearch(arr, mid+1, high, target);
        }
        if(arr[mid] > target) {
            return binarySearch(arr, low, mid-1, target);
        }
        return mid;
    }
}
