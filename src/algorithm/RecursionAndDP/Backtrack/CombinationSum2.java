package algorithm.RecursionAndDP.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(rst, candidates, target, 0, new ArrayList<>());
        return rst;
    }

    public static void backtrack(List<List<Integer>> rst, int[] nums, int remain, int start, List<Integer> path) {
        if(remain < 0) return;
        if (remain == 0) {
            rst.add(new ArrayList<>(path));
        }
        for (int i=start; i<nums.length; i++) {
            if (i != start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backtrack(rst, nums, remain - nums[i], i+1, path);
            path.remove(path.size()-1);
        }
    }
}
