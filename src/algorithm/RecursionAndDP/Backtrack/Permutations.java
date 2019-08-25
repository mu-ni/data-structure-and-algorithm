package algorithm.RecursionAndDP.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(rst, nums, new ArrayList<>());
        return rst;
    }

    public static void dfs(List<List<Integer>> rst, int[] nums, List<Integer> path) {
        if(nums.length == path.size()) {
            rst.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i< nums.length; i++) {
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            dfs(rst, nums, path);
            path.remove(path.size()-1);
        }
    }
}
