package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        System.out.println(pathSum(TreeNode.genTree(), 9));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<>();

        return rst;
    }

    public static void dfs(List<List<Integer>> rst, TreeNode node, int sum, List<Integer> path) {
        if (path.stream().mapToInt(Integer::intValue).sum() == sum) {
            rst.add(new ArrayList<>(path));
            return;
        }


    }
}
