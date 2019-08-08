package algorithm.RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.print(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        rst.add(new ArrayList<>());
        for(int n : nums) {
            int size = rst.size();
            for (int i=0; i< size; i++) {
                List<Integer> subset = new ArrayList<>();
                subset.addAll(rst.get(i));
                subset.add(n);
                rst.add(subset);
            }
        }
        return rst;
    }

    // recursion
//    public List<List<Integer>> subsets(int[] nums) {
//        // Arrays.sort(nums);
//        List<List<Integer>> rst = new ArrayList<>();
//        backtrack(rst, nums, new ArrayList<>(), 0);
//        return rst;
//    }
//
//    public void dfs(List<List<Integer>> rst, int[] nums, List<Integer> path, int start) {
//        rst.add(new ArrayList<>(path));
//        for(int i=start; i< nums.length; i++) {
//            path.add(nums[i]);
//            backtrack(rst, nums, path, i+1);
//            path.remove(path.size()-1);
//        }
//    }
}
