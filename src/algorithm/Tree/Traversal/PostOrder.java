package algorithm.Tree.Traversal;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    public static void main(String[] args) {
        System.out.println(new PostOrder().postOrder(TreeNode.genTree()));
        System.out.println(new PostOrder().postOrder2(TreeNode.genTree()));
    }

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        postOrder(rst, root);
        return rst;
    }

    public void postOrder(List<Integer> rst, TreeNode node) {
        if (node == null) return;
        postOrder(rst, node.left);
        postOrder(rst, node.right);
        rst.add(node.val);
    }

    public List<Integer> postOrder2(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.push(node);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        while (!output.isEmpty()) {
            rst.add(output.pop().val);
        }
        return rst;
    }
}
