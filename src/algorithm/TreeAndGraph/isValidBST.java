package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.Stack;

public class isValidBST {
    public static void main(String[] args) {
        System.out.println(isValidBST(TreeNode.genTree()));
        System.out.println(isValidBST2(TreeNode.genTree()));
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

    // inorder -> 结果从小到大排列
    public static boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode left = null;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(left != null && left.val >= node.val) return false;
            left = node;
            node = node.right;
        }
        return true;
    }
}