package algorithm.Backtrack;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(combinationSum2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(rst, candidates, target, 0, new ArrayList<>());
        return rst;
    }

    public void backtrack(List<List<Integer>> rst, int[] nums, int remain, int start, List<Integer> path) {
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

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> rst = new HashSet<>();
        Arrays.sort(candidates);
        backtrack(rst, candidates, target, 0, new ArrayList<>());
        return new ArrayList<>(rst);
    }

    public void backtrack(Set<List<Integer>> rst, int[] candidates, int remain, int start, List<Integer> path) {
        if (remain < 0) return;
        if (remain == 0) {
            rst.add(new ArrayList<>(path));
            return;
        }

        for (int i=start; i<candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(rst, candidates, remain-candidates[i], i+1, path);
            path.remove(path.size()-1);
        }
    }
}
