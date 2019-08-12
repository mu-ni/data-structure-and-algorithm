package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class IsBalanced {
    public static void main(String[] args) {
        System.out.println(depth(TreeNode.genTree()));
        System.out.println(isBalanced(TreeNode.genTree()));
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
}
