package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeNode.genTree();
        preOrder(root);
        System.out.println("------");
        inOrder(root);
        System.out.println("------");
        postOrder(root);
    }

    public static void preOrder(TreeNode node) {
        if (node == null) return;
        TreeNode.visit(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        TreeNode.visit(node);
        inOrder(node.right);
    }

    public static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        TreeNode.visit(node);
    }
}
