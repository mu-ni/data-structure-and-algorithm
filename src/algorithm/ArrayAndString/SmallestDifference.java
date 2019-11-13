package algorithm.ArrayAndString;

import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        System.out.println(new SmallestDifference().smallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
    }

    public int smallestDifference(int[] arr1, int[] arr2) {
        int rst = Integer.MAX_VALUE;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < arr1.length && i2 < arr2.length) {
            if (arr1[i1] == arr2[i2]) return 0;
            rst = Math.min(rst,Math.abs(arr1[i1] - arr2[i2]));
            if (arr1[i1] < arr2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        return rst;
    }
}
