package algorithm.RecursionAndDP.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
        System.out.println(subsets2(new int[]{1,2,3}));
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
    // O(n*2^n)
    // O(n*2^n)
    public static List<List<Integer>> subsets2(int[] nums) {
        // Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        backtrack(rst, nums, new ArrayList<>(), 0);
        return rst;
    }

    public static void backtrack(List<List<Integer>> rst, int[] nums, List<Integer> path, int start) {
        rst.add(new ArrayList<>(path));
        for(int i=start; i< nums.length; i++) {
            path.add(nums[i]);
            backtrack(rst, nums, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
