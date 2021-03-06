package algorithm.ArrayAndString;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays2(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len%2 == 1) {
            return helper(nums1, 0, nums2, 0, len/2+1);
        }
        double left = helper(nums1, 0, nums2, 0, len/2);
        double right = helper(nums1, 0, nums2, 0, len/2+1);
        return (left + right)/2;
    }

    // find the kth in nums1 & nums2
    public double helper(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) return nums2[start2 + k -1];
        if (start2 >= nums2.length) return nums1[start1 + k -1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int mid1 = start1 + k/2 -1;
        int mid2 = start2 + k/2 -1;
        int midVal1 = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
        int midVal2 = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];

        if (midVal1 <= midVal2) {
            return helper(nums1, mid1+1, nums2, start2, k-k/2);
        }
        return helper(nums1, start1, nums2, mid2+1, k-k/2);
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0;
        for (int n1 : nums1) {
            nums[index++] = n1;
        }
        for (int n2 : nums2) {
            nums[index++] = n2;
        }
        Arrays.sort(nums);
        int len = nums.length;
        return len%2 == 1 ? nums[len/2] : (double)(nums[len/2] + nums[len/2-1])/2;
    }
}
