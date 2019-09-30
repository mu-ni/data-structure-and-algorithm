package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueBST2 {
    public static void main(String[] args) {
        List<TreeNode> rst = new UniqueBST2().generateTrees(3);
        rst.stream().map(TreeNode::tree2arr).forEach(node -> System.out.println(node.toString()));
        System.out.println("-------------");
        rst.stream().map(TreeNode::tree2arrRemoveDupNull).forEach(node -> System.out.println(node.toString()));

        System.out.println();
        rst = new UniqueBST2().generateTrees2(3);
        rst.stream().map(TreeNode::tree2arr).forEach(node -> System.out.println(node.toString()));
        System.out.println("-------------");
        rst.stream().map(TreeNode::tree2arrRemoveDupNull).forEach(node -> System.out.println(node.toString()));
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> rst = new ArrayList<>();

        if (start > end) {
            rst.add(null);
            return rst;
        }

        if (start == end) {
            rst.add(new TreeNode(start));
            return rst;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = helper(start, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    rst.add(root);
                }
            }
        }

        return rst;
    }

    public List<TreeNode> generateTrees2(int n) {
        if (n == 0) return new ArrayList<>();

        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                int l = j - 1;
                int r = i - j;
                for (TreeNode left : dp[l]) {
                    for (TreeNode right : dp[r]) {
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = clone(right, j);
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode clone(TreeNode root, int offset) {
        if (root == null) return null;

        TreeNode newRoot = new TreeNode(root.val + offset);
        newRoot.left = clone(root.left, offset);
        newRoot.right = clone(root.right, offset);
        return newRoot;
    }
}
