package algorithm.ArrayAndString;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                    continue;
                }
                if (nums[left] + nums[right] > target) {
                    right--;
                    continue;
                }
                rst.add(Arrays.asList(nums[left], nums[right], nums[i]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left-1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right+1]) {
                    right--;
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
