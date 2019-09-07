package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.arr2tree(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(new IsSymmetric().isSymmetric(tree));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
