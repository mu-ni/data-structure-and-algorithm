package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;
import algorithm.Tree.Traversal.PreOrder;

import java.util.Stack;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode tree = new InvertTree().invertTree(TreeNode.genTree());
        System.out.println(new PreOrder().preOrder(tree));

        System.out.println();
        tree = new InvertTree().invertTree2(TreeNode.genTree());
        System.out.println(new PreOrder().preOrder(tree));

        System.out.println();
        tree = new InvertTree().invertTree3(TreeNode.genTree());
        System.out.println(new PreOrder().preOrder(tree));
    }

    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode node) {
        if (node == null) return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        invertTree(node.left);
        invertTree(node.right);
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.right = left;
            node.left = right;
            if (left != null) {
                stack.push(left);
            }
            if (right != null) {
                stack.push(right);
            }
        }
        return root;
    }
}
