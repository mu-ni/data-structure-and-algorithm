package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.Tree;

public class TreeTraversal {
    public static void main(String[] args) {
        Tree root = Tree.genTree();
        preOrder(root);
        System.out.println("------");
        inOrder(root);
        System.out.println("------");
        postOrder(root);
    }

    public static void preOrder(Tree node) {
        if (node == null) return;
        visit(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Tree node) {
        if (node == null) return;
        inOrder(node.left);
        visit(node);
        inOrder(node.right);
    }

    public static void postOrder(Tree node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        visit(node);
    }

    public static void visit(Tree node) {
        System.out.println(node.val);
    }
}
