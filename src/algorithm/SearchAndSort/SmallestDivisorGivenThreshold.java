package algorithm.SearchAndSort;

/**
 * Created by muni on 2019/12/27
 */
public class SmallestDivisorGivenThreshold {
    public static void main(String[] args) {
        System.out.println(new SmallestDivisorGivenThreshold().smallestDivisor(new int[]{1,2,5,9}, 6));
    }

    // sum <= threshold
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = nums[0];
        for (int n : nums) {
            end = Math.max(end, n);
        }

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (sum(nums, mid) <= threshold) {
                if (mid == start || sum(nums, mid-1) > threshold) return mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public int sum(int[] nums, int divisor) {
        int sum = 0;
        for (int n : nums) {
            sum += Math.ceil((double) n/divisor);
        }
        return sum;
    }
}
