package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        System.out.println(new CousinsInBinaryTree().isCousins(TreeNode.arr2tree(new Integer[]{1, 2, 4, 5, 3}), 4, 5));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int depX = getDepth(root, x, 0);
        int depY = getDepth(root, y, 0);
        TreeNode parX = getParent(root, x);
        TreeNode parY = getParent(root, y);
        return depX == depY && parX != parY;
    }

    public int getDepth(TreeNode node, int val, int depth) {
        if (node == null) return -1;
        if (node.val == val) return depth;
        return Math.max(getDepth(node.left, val, depth + 1), getDepth(node.right, val, depth + 1));
    }

    public TreeNode getParent(TreeNode node, int val) {
        if (node == null || node.val == val) return null;
        if (node.left != null && node.left.val == val) return node;
        if (node.right != null && node.right.val == val) return node;

        TreeNode left = getParent(node.left, val);
        TreeNode right = getParent(node.right, val);
        return left == null ? right : left;
    }
}
