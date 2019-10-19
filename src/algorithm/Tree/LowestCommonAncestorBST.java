package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

public class LowestCommonAncestorBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        TreeNode p = root.left;
        TreeNode q = root.left.right.left;

        TreeNode ancestor = lowestCommonAncestor(root, p, q);
        System.out.println(ancestor == null ? null : ancestor.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
