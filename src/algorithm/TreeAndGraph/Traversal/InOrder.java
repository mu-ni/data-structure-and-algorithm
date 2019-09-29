package algorithm.TreeAndGraph.Traversal;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    public static void main(String[] args) {
        System.out.println(new InOrder().inOrder(TreeNode.genTree()));
        System.out.println(new InOrder().inOrder2(TreeNode.genTree()));
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        inOrder(rst, root);
        return rst;
    }

    public void inOrder(List<Integer> rst, TreeNode node) {
        if (node == null) return;
        inOrder(rst, node.left);
        rst.add(node.val);
        inOrder(rst, node.right);
    }

    public List<Integer> inOrder2(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            rst.add(cur.val);
            cur = cur.right;
        }
        return rst;
    }
}
