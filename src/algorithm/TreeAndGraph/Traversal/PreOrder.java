package algorithm.TreeAndGraph.Traversal;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public static void main(String[] args) {
        System.out.println(new PreOrder().preOrder(TreeNode.genTree()));
        System.out.println(new PreOrder().preOrder2(TreeNode.genTree()));
    }

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        preOrder(rst, root);
        return rst;
    }

    public void preOrder(List<Integer> rst, TreeNode node) {
        if (node == null) return;
        rst.add(node.val);
        preOrder(rst, node.left);
        preOrder(rst, node.right);
    }

    public List<Integer> preOrder2(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            rst.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return rst;
    }
}
