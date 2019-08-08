package algorithm.searchAndSort.basic;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(radix(new int[]{29,25,3,49,9,37,21,43})));
    }

    public static int[] radix(int[] arr) {
        return radix(arr, 5);
    }

    public static int[] radix(int[] arr, int bucketSize) {
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.ceil((float)(maxValue - minValue) / bucketSize);
        int[][] buckets = new int[bucketCount][0];

        for (int value : arr) {
            int index = (int) Math.floor((value-minValue)/bucketSize);
            buckets[index] = append(buckets[index], value);
        }

        int index = 0;
        for(int[] bucket : buckets) {
            if (bucket.length == 0) {
                continue;
            }

            bucket = insertion(bucket);
            for(int value : bucket) {
                arr[index] = value;
                index++;
            }
        }

        return arr;
    }

    public static int[] append(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static int[] insertion(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            int tmp = nums[i];
            while(i >=1 && tmp < nums[i-1]) {
                nums[i] = nums[i-1];
                i--;
            }
            nums[i] = tmp;
        }
        return nums;
    }
}
