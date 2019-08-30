package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class MaxDepthBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left, 1), maxDepth(root.right, 1));
    }

    public static int maxDepth(TreeNode node, int depth) {
        if (node == null) return depth;
        depth++;
        return Math.max(maxDepth(node.left, depth), maxDepth(node.right, depth));
    }
}
