package algorithm.SearchAndSort;

import java.util.Arrays;

public class PeakValley {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(peakValley(new int[]{0,1,4,7,8,9})));
        System.out.println(Arrays.toString(peakValley2(new int[]{0,1,4,7,8,9})));
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

    // time complexity O(n)
    public static int[] peakValley2(int[] arr) {
        for(int i=0; i<arr.length-1; i += 2) {
            int maxIndex = maxIndex(arr, i-1, i, i+1);
            if(arr[maxIndex] != arr[i]) {
                swap(arr, maxIndex, i);
            }
        }
        return arr;
    }

    private static int maxIndex(int[] arr, int a, int b, int c) {
        int lastIndex = arr.length-1;
        int A = a >= 0 && a <= lastIndex ? arr[a] : Integer.MIN_VALUE;
        int B = b >= 0 && b <= lastIndex ? arr[b] : Integer.MIN_VALUE;
        int C = c >= 0 && c <= lastIndex ? arr[c] : Integer.MIN_VALUE;

        int max = Math.max(A, Math.max(B,C));
        if(A == max) return a;
        if(B == max) return b;
        return c;
    }
}
