package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

public class DiameterOfBT {
    public static void main(String[] args) {
        System.out.println(new DiameterOfBT().diameterOfBinaryTree(TreeNode.arr2tree(new Integer[]{3,2,3,4,5})));
        System.out.println(new DiameterOfBT().diameterOfBinaryTree2(TreeNode.arr2tree(new Integer[]{3,2,3,4,5})));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int withRoot = maxDepth(root.left, 0) + maxDepth(root.right, 0);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        return Math.max(withRoot, Math.max(left, right));
    }

    public int maxDepth(TreeNode node, int depth) {
        if (node == null) return depth;
        depth++;
        return Math.max(maxDepth(node.left, depth), maxDepth(node.right, depth));
    }

    int rst;
    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return rst - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        rst = Math.max(rst, l + r + 1);
        return 1 + Math.max(l, r);
    }
}
