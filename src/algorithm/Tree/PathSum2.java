package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        System.out.println(pathSum(TreeNode.genTree(), 9));
        System.out.println(pathSum2(TreeNode.genTree(), 9));
    }

    // root-to-leaf paths
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(rst, root, sum, new ArrayList<>());
        return rst;
    }

    public static void dfs(List<List<Integer>> rst, TreeNode node, int sum, List<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        sum -= node.val;

        if (node.left == null && node.right == null && sum == 0) {
            rst.add(new ArrayList<>(path));
        } else {
            dfs(rst, node.left, sum, path);
            dfs(rst, node.right, sum, path);
        }
        path.remove(path.size() - 1);
    }

    public static List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<>();
        backtrack(rst, root, sum, new ArrayList<>());
        return rst;
    }

    public static void backtrack(List<List<Integer>> rst, TreeNode node, int rem, List<Integer> path) {
        if (node == null) return;

        if (rem == node.val && node.left == null && node.right == null) {
            path.add(node.val);
            rst.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        path.add(node.val);
        backtrack(rst, node.left, rem-node.val, path);
        backtrack(rst, node.right, rem-node.val, path);
        path.remove(path.size()-1);
    }
}
