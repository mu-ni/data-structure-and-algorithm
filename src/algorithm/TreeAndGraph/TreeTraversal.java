package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.Stack;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeNode.genTree();
        preOrder(root);
        System.out.println();
        preOrder2(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        inOrder2(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        postOrder2(root);
    }

    public static void preOrder(TreeNode node) {
        if (node == null) return;
        TreeNode.visit(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void preOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode.visit(cur);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        TreeNode.visit(node);
        inOrder(node.right);
    }

    public static void inOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            TreeNode.visit(cur);
            cur = cur.right;
        }
    }

    public static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        TreeNode.visit(node);
    }

    public static void postOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                output.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;
        }

        while (!output.isEmpty()) {
            TreeNode.visit(output.pop());
        }
    }
}
