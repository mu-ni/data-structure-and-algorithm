package algorithm.SearchAndSort;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3)));
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        m--; // size -> index
        n--; // size -> index
        while(m >= 0 && n >=0) {
            if(nums1[m] > nums2[n]) {
                nums1[index] = nums1[m];
                m--;
            } else {
                nums1[index] = nums2[n];
                n--;
            }
            index--;
        }
        while(m >=0) {
            nums1[index] = nums1[m];
            m--;
            index--;
        }
        while(n >=0) {
            nums1[index] = nums2[n];
            n--;
            index--;
        }
        return nums1;
    }
}
