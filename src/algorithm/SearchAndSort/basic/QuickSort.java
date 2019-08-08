package algorithm.SearchAndSort.basic;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{1,4,2,6,9,3,7,8,5})));
    }

    // time complexity O(nlogn)
    // space complexity O(logn)
    public static int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        int partition = partition(nums, left, right);
        if (left < partition) {
            quickSort(nums, left, partition);
        }
        if (partition+1 < right) {
            quickSort(nums, partition+1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right)/2];
        while(left < right) {
            while(arr[left] < pivot) {
                left++;
            }
            while(arr[right] > pivot) {
                right--;
            }
            if(left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return right;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
