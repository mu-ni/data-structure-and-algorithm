package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class isValidBST {
    public static void main(String[] args) {
        System.out.println(isValidBST(TreeNode.genTree()));
    }

    public static boolean isValidBST(TreeNode node) {
        return isValidBST(node, null, null);
    }

    public static boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}