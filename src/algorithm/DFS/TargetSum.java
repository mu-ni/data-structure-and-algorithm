package algorithm.DFS;

/**
 * Created by muni on 2020/1/19
 */
public class TargetSum {
    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    int count = 0;
    int S = 0;
    public int findTargetSumWays(int[] nums, int S) {
        this.S = S;
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int i, int sum) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
            return;
        }
        dfs(nums, i+1, sum + nums[i]);
        dfs(nums, i+1, sum - nums[i]);
    }
}
