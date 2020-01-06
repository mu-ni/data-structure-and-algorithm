package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        System.out.println(new PathSum2().pathSum(TreeNode.genTree(), 9));
        System.out.println(new PathSum2().pathSum2(TreeNode.genTree(), 9));
    }

    // root-to-leaf paths
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(rst, root, sum, new ArrayList<>());
        return rst;
    }

    public void dfs(List<List<Integer>> rst, TreeNode node, int sum, List<Integer> path) {
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

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        backtrack(rst, root, sum, new ArrayList<>());
        return rst;
    }

    public void backtrack(List<List<Integer>> rst, TreeNode node, int rem, List<Integer> path) {
        if (node == null) return;

        path.add(node.val);
        if (node.val == rem && node.left == null && node.right == null) {
            rst.add(new ArrayList<>(path));
        } else {
            backtrack(rst, node.left, rem - node.val, path);
            backtrack(rst, node.right, rem - node.val, path);
        }
        path.remove(path.size()-1);
    }
}
