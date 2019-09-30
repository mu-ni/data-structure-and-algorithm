package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;
import algorithm.Tree.Traversal.PreOrder;

public class FlattenBT {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{1,2,5,3,4,null,6});
        flatten(root);
        System.out.println(new PreOrder().preOrder(root));
        root = TreeNode.arr2tree(new Integer[]{1,2,5,3,4,null,6});
        flatten2(root);
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

    public static void flatten2(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left == null) {
                cur = cur.right;
                continue;
            }
            while (left.right != null) {
                left = left.right;
            }
            left.right = cur.right;
            cur.right = cur.left;
            cur.left = null;
            cur = cur.right;
        }
    }
}
