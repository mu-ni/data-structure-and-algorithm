package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

public class LowestCommonAncestorBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        TreeNode p = root.left;
        TreeNode q = root.left.right.left;

        TreeNode ancestor = lowestCommonAncestor(root, p, q);
        System.out.println(ancestor == null ? null : ancestor.val);
        ancestor = lowestCommonAncestor2(root, p, q);
        System.out.println(ancestor == null ? null : ancestor.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (root.val > min && root.val < max) return root;
        if (root.val > min && root.val > min) return lowestCommonAncestor2(root.left, p, q);
        return lowestCommonAncestor2(root.right, p, q);
    }
}
