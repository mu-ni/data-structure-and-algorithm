package algorithm.SearchAndSort.basic;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1,4,6,8,9}, new int[]{2,3,5,7})));
        System.out.println(Arrays.toString(mergeSort(new int[]{1,4,2,6,9,3,7,8,5})));
    }

    // time complexity O(nlogn)
    // space complexity O(n)
    public static int[] mergeSort(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    public static int[] mergeSort(int[] nums, int low, int high) {
        int mid = (low + high)/2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = 0;
        int i1 = low;
        int i2 = mid+1;

        while(i1 <= mid && i2 <= high) {
            if(nums[i1] > nums[i2]) {
                tmp[i] = nums[i2];
                i2++;
            } else {
                tmp[i] = nums[i1];
                i1++;
            }
            i++;
        }

        while(i1 <= mid) {
            tmp[i] = nums[i1];
            i1++;
            i++;
        }

        while(i2 <= high) {
            tmp[i] = nums[i2];
            i2++;
            i++;
        }

        // copy tmp to nums
        i=0;
        while(i < tmp.length) {
            nums[low] = tmp[i];
            low++;
            i++;
        }
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int i1 = 0;
        int i2 = 0;

        while(i1 < arr1.length && i2 < arr2.length) {
            if(arr1[i1] < arr2[i2]) {
                arr[i] = arr1[i1];
                i1++;
            } else {
                arr[i] = arr2[i2];
                i2++;
            }
            i++;
        }

        while(i1 < arr1.length) {
            arr[i] = arr1[i1];
            i1++;
            i++;
        }

        while(i2 < arr2.length) {
            arr[i] = arr2[i2];
            i2++;
            i++;
        }

        return arr;
    }
}
