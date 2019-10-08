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
        boolean[] visited = new boolean[nums.length];
        dfs(rst, nums, new ArrayList<>(), visited);
        return rst;
    }

    public static void dfs(List<List<Integer>> rst, int[] nums, List<Integer> path, boolean[] visited) {
        if(nums.length == path.size()) {
            rst.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i] || i != 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;
            dfs(rst, nums, path, visited);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
}
