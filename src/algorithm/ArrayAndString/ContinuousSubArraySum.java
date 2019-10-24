package algorithm.ArrayAndString;

public class ContinuousSubArraySum {
    public static void main(String[] args) {
        System.out.println(new ContinuousSubArraySum().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i=0; i<nums.length; i++) {
            int sum =nums[i];
            for (int j=i+1; j<nums.length; j++) {
                sum += nums[j];
                if ((k == 0 && sum == 0) || (k != 0 && sum % k == 0)) return true;
            }
        }
        return false;
    }
}
