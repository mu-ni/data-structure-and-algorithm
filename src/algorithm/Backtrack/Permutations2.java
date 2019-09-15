package algorithm.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(rst, nums, new ArrayList<>(), used);
        return rst;
    }

    public static void dfs(List<List<Integer>> rst, int[] nums, List<Integer> path, boolean[] used) {
        if(nums.length == path.size()) {
            rst.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i] || i != 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            dfs(rst, nums, path, used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
