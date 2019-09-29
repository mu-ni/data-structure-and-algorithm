package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;
import algorithm.TreeAndGraph.Traversal.PreOrder;

public class FlattenBT {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{1,2,5,3,4,null,6});
        flatten(root);
        System.out.println(new PreOrder().preOrder(root));
    }

    public static void flatten(TreeNode root) {
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
    }
}
