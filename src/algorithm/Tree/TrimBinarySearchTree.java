package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;
import algorithm.Tree.Traversal.PreOrder;

public class TrimBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{3,0,4,null,2,null,null,null,null,1});
        TreeNode tree = new TrimBinarySearchTree().trimBST(root, 1, 3);
        System.out.println(new PreOrder().preOrder(tree));

        root = TreeNode.arr2tree(new Integer[]{3,0,4,null,2,null,null,null,null,1});
        tree = new TrimBinarySearchTree().trimBST2(root, 1, 3);
        System.out.println(new PreOrder().preOrder(tree));
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public TreeNode trimBST2(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST2(root.right, L, R);
        if (root.val > R) return trimBST2(root.left, L, R);

        root.left = trimBST2(root.left, L, root.val);
        root.right = trimBST2(root.right, root.val, R);
        return root;
    }
}
