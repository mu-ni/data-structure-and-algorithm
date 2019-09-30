package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.arr2tree(new Integer[]{1,2,3});
        TreeNode tree2 = TreeNode.arr2tree(new Integer[]{1,2,3});
        System.out.println(isSameTree(tree1, tree2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
