package algorithm.Backtrack;

import java.util.*;

public class IncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new IncreasingSubsequence().findSubsequences(new int[]{4,6,7,7}));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Set<List<Integer>> rst = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            backtrack(rst, nums, i, new ArrayList<>());
        }
        return new ArrayList<>(rst);
    }

    public void backtrack(Set<List<Integer>> rst, int[] nums, int start, List<Integer> path) {
        if (path.size() >= 2) {
            rst.add(new ArrayList<>(path));
        }

        for (int i=start; i<nums.length; i++) {
            if (path.size() > 0 && nums[i] < path.get(path.size()-1)) continue;
            path.add(nums[i]);
            backtrack(rst, nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
