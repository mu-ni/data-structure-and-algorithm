package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class DiameterOfBT {
    public static void main(String[] args) {
        System.out.println(new DiameterOfBT().diameterOfBinaryTree(TreeNode.arr2tree(new Integer[]{3,2,3,4,5})));
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
}
