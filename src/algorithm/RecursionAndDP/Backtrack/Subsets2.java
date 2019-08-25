package algorithm.RecursionAndDP.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        System.out.print(subsetsWithDup(new int[]{1,2,2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        backtrack(rst, nums, new ArrayList<>(), 0);
        return rst;
    }

    public static void backtrack(List<List<Integer>> rst, int[] nums, List<Integer> path, int start) {
        rst.add(new ArrayList<>(path));
        for(int i=start; i<nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backtrack(rst, nums, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
