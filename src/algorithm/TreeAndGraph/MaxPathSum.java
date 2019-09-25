package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class MaxPathSum {
    public static void main(String[] args) {
        System.out.println(new MaxPathSum().maxPathSum(TreeNode.genTree()));
    }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxBranchSum(root);
        return max;
    }

    public int maxBranchSum(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(maxBranchSum(node.left), 0);
        int right = Math.max(maxBranchSum(node.right), 0);
        max = Math.max(node.val+left+right, max);
        return node.val + Math.max(left, right);
    }
}
