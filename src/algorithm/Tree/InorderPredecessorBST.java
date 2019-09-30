package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

public class InorderPredecessorBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{3,1,4, null, 2});
        TreeNode successor = inorderPredecessor(root, new TreeNode(2));
        System.out.println(successor == null ? null : successor.val);
    }

    public static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val >= p.val) return inorderPredecessor(root.left, p);

        TreeNode right = inorderPredecessor(root.right, p);
        return right == null ? root : right;
    }
}
