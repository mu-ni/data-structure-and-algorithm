package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class InorderSuccessorBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{3,1,4, null, 2});
        TreeNode successor = inorderSuccessor(root, new TreeNode(2));
        System.out.println(successor == null ? null : successor.val);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) return inorderSuccessor(root.right, p);

        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }
}
