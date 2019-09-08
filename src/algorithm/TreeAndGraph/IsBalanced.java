package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class IsBalanced {
    public static void main(String[] args) {
        System.out.println(depth(TreeNode.genTree()));
        System.out.println(isBalanced(TreeNode.genTree()));
        System.out.println(isBalanced2(TreeNode.genTree()));
    }

    // O(nlogn)
    public static boolean isBalanced(TreeNode node) {
        if (node == null) return true;

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    public static int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) +1;
    }

    // O(n)
    public static boolean isBalanced2(TreeNode root) {
        if (root == null) return true;

        return helper(root) != -1;
    }

    public static int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right)+1;
    }
}
