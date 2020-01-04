package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.Stack;

public class IsValidBST {
    public static void main(String[] args) {
        System.out.println(new IsValidBST().isValidBST(TreeNode.genTree()));
        System.out.println(new IsValidBST().isValidBST2(TreeNode.genTree()));
        System.out.println(new IsValidBST().isValidBST3(TreeNode.genTree()));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    // inorder -> 结果从小到大排列
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode left = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (left != null && left.val >= cur.val) return false;
            left = cur;
            cur = cur.right;
        }
        return true;
    }

    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;
        return isValidBST3(root.left, Integer.MIN_VALUE, root.val)
                && isValidBST3(root.right, root.val, Integer.MAX_VALUE);
    }

    // [-2147483648,null,2147483647] not work
    public boolean isValidBST3(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val >= max || node.val <= min) return false;
        return isValidBST3(node.left, min, node.val)
                && isValidBST3(node.right, node.val, max);
    }
}