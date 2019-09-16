package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest3(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest4(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    // O(nlogn)
    // O(1)
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // O(nlogk)
    // O(k)
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.poll(); // poll smallest
            }
        }
        return queue.peek();
    }

    // O(nlogn)
    // O(1)
    public static int findKthLargest3(int[] nums, int k) {
//        shuffle(nums); // O(logn)
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int p = partition(nums, lo, hi);
            if (p < k) {
                lo++;
                continue;
            }
            if (p > k) {
                hi--;
                continue;
            }
            break;
        }
        return nums[k];
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int l = left;
        int r = right - 1;
        while (true) {
            while (l < right && nums[l] <= pivot) {
                l++;
            }
            while (r >= left && nums[r] >= pivot) {
                r--;
            }
            if (l >= r) break;
            swap(nums, l, r);
        }
        swap(nums, l, right);
        return l;
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void shuffle(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int seed = new Random().nextInt(nums.length);
            swap(nums, i, seed);
        }
    }

    public static int findKthLargest4(int[] nums, int k) {
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            maxIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(nums, i, maxIndex);
        }
        return nums[k - 1];
    }
}
