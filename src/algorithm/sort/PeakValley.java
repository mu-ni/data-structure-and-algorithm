package algorithm.sort;

import java.util.Arrays;

public class PeakValley {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(peakValley(new int[]{0,1,4,7,8,9})));
    }

    // time complexity O(nlogn)
    // Arrays.sort() -> TimSort from jdk 1.7, time complexity O(n)<~<O(nlogn), space complexity O(n/2)
    public static int[] peakValley(int[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i += 2) {
            swap(arr, i, i+1);
        }
        return arr;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
