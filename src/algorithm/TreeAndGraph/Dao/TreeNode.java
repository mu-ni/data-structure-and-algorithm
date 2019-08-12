package algorithm.TreeAndGraph.Dao;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public boolean visited = false;

    public TreeNode(int val) {
        this.val = val;
    }

    public List<TreeNode> adjacent() {
        List<TreeNode> list = new ArrayList<>();
        if (left != null) list.add(left);
        if (right != null) list.add(right);
        return list;
    }

    public static TreeNode genTree() {
        TreeNode root = new TreeNode(4);
        TreeNode child1 = new TreeNode(3);
        TreeNode leaf1 = new TreeNode(1);
        TreeNode leaf2 = new TreeNode(2);
        TreeNode child2 = new TreeNode(5);
        TreeNode leaf3 = new TreeNode(6);
        TreeNode leaf4 = new TreeNode(7);

        root.left = child1;
        root.right = child2;
        child1.left = leaf1;
        child1.right = leaf2;
        child2.left = leaf3;
        child2.right = leaf4;

        return root;
    }

    public static void visit(TreeNode node) {
        System.out.println(node.val);
    }
}
