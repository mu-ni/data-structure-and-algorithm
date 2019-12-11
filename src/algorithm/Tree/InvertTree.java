package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;
import algorithm.Tree.Traversal.PreOrder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode tree = new InvertTree().invertTree(TreeNode.genTree());
        System.out.println(new PreOrder().preOrder(tree));

        tree = new InvertTree().invertTree2(TreeNode.genTree());
        System.out.println(new PreOrder().preOrder(tree));

        tree = new InvertTree().invertTree3(TreeNode.genTree());
        System.out.println(new PreOrder().preOrder(tree));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
