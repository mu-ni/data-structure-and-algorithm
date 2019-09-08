package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class HasPathSum {
    public static void main(String[] args) {
        System.out.println(hasPathSum(TreeNode.genTree(), 9));
    }

    public static boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return node.val == sum;

        return hasPathSum(node.left, sum - node.val) || hasPathSum(node.right, sum - node.val);
    }
}
