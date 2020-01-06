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
        root = TreeNode.arr2tree(new Integer[]{1,2,5,3,4,null,6});
        flatten3(root);
        System.out.println(new PreOrder().preOrder(root));
        root = TreeNode.arr2tree(new Integer[]{1,2,5,3,4,null,6});
        flatten4(root);
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

    public static void flatten3(TreeNode root) {
        while (true) {
            while (root != null && root.left == null) {
                root = root.right;
            }
            if (root == null) return;

            TreeNode left = root.left;
            TreeNode leftRightTail = left;
            while (leftRightTail.right != null) {
                leftRightTail = leftRightTail.right;
            }
            TreeNode tmp = root.right;
            root.right = left;
            leftRightTail.right = tmp;

            root.left = null;
            root = root.right;
        }
    }

    public static void flatten4(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        if (left != null) {
            TreeNode leftRight = left;
            while (leftRight.right != null) {
                leftRight = leftRight.right;
            }
            leftRight.right = root.right;
            root.right = left;
            root.left = null;
        }

        flatten(root.right);
    }
}
