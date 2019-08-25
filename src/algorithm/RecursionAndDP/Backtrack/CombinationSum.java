package algorithm.RecursionAndDP.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        backtrack(rst, candidates, target, 0, new ArrayList<>());
        return rst;
    }

    public static void backtrack(List<List<Integer>> rst, int[] nums, int remain, int start, List<Integer> path) {
        if(remain < 0) return;
        if (remain == 0) {
            rst.add(new ArrayList<>(path));
        }
        for (int i=start; i<nums.length; i++) {
            path.add(nums[i]);
            backtrack(rst, nums, remain - nums[i], i, path);
            path.remove(path.size()-1);
        }
    }
}
