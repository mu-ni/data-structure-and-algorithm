package algorithm.TwoPointers;

public class NumberOfNiceSubarrays {
    public static void main(String[] args) {
        System.out.println(new NumberOfNiceSubarrays().numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
    }

    public int atMostK(int[] nums, int k) {
        int count = 0;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast]%2 == 1) k--;
            fast++;
            while (k < 0) {
                if (nums[slow]%2 ==1) k++;
                slow++;
            }
            count += fast-slow;
        }
        return count;
    }
}
