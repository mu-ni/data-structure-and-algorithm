package algorithm.Backtrack;

/**
 * Created by muni on 2020/1/16
 */
public class PartitionKEqualSumSubsets {
    public static void main(String[] args) {
        System.out.println(new PartitionKEqualSumSubsets().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }
        if (sum%k != 0 || max > sum/k) return false;

        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, 0, visited, k, 0, sum/k);
    }

    private boolean backtrack(int[] nums, int start, boolean[] visited, int k, int sum, int target) {
        if (k == 0) return true;
        if (sum > target) return false;
        if (sum == target) return backtrack(nums, 0, visited, k-1, 0, target);

        for (int i=start; i<nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            boolean isValid = backtrack(nums, i+1, visited, k, sum + nums[i], target);
            visited[i] = false;
            if (isValid) return true;
        }
        return false;
    }
}
