package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class FlattenBT {
    public static void main(String[] args) {
        TreeNode root = new FlattenBT().flatten(TreeNode.arr2tree(new Integer[]{1,2,5,3,4,null,6}));
        TreeTraversal.inOrder(root);
    }

    public TreeNode flatten(TreeNode root) {
        TreeNode node = root;
        while (root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            }
            TreeNode pre = root.left;
            while (pre.right != null) {
                pre = pre.right;
            }
            pre.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
        return node;
    }
}
