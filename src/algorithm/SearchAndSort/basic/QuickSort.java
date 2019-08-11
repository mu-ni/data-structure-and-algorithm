package algorithm.SearchAndSort.basic;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{5, 3, 2, 1})));
    }

    // time complexity O(nlogn)
    // space complexity O(logn)
    public static int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int partition = partition(nums, left, right);
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];

        int i = left;
        int j = right - 1;
        while (true) {
            while (i <= right-1 && arr[i] <= pivot) {
                i++;
            }
            while (j >= left && arr[j] >= pivot) {
                j--;
            }
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, i, right);
        return i;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
