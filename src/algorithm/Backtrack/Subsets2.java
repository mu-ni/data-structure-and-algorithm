package algorithm.Backtrack;

import java.util.*;

public class Subsets2 {
    public static void main(String[] args) {
        Subsets2 subsets2 = new Subsets2();
        System.out.println(subsets2.subsetsWithDup(new int[]{1,2,2}));
        System.out.println(subsets2.subsetsWithDup2(new int[]{1,2,2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(rst, nums, new ArrayList<>(), 0);
        return rst;
    }

    public void backtrack(List<List<Integer>> rst, int[] nums, List<Integer> path, int start) {
        rst.add(new ArrayList<>(path));
        for(int i=start; i<nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backtrack(rst, nums, path, i+1);
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Set<List<Integer>> rst = new HashSet<>();
        Arrays.sort(nums);
        backtrack(rst, nums, 0, new ArrayList<>());
        return new ArrayList<>(rst);
    }

    public void backtrack(Set<List<Integer>> rst, int[] nums, int start, List<Integer> path) {
        rst.add(new ArrayList<>(path));

        for (int i=start; i<nums.length; i++) {
            path.add(nums[i]);
            backtrack(rst, nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
