package algorithm.RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                if (nums[head] + nums[tail] == target) {
                    rst.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    head++;
                    tail--;
                    while (head < tail && nums[head] == nums[head - 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail + 1]) {
                        tail--;
                    }
                } else if (nums[head] + nums[tail] > target) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return rst;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        threeSum(rst, nums, 0, 0, new ArrayList<>());
        return rst;
    }

    public static void threeSum(List<List<Integer>> rst, int[] nums, int sum, int start, List<Integer> path) {
        if (path.size() > 3) return;
        if (path.size() == 3 && sum == 0) {
            rst.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            threeSum(rst, nums, sum + nums[i], i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
