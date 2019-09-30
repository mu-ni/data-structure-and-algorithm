package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HasPathSum {
    public static void main(String[] args) {
        System.out.println(hasPathSum(TreeNode.genTree(), 9));
        System.out.println(hasPathSum2(TreeNode.genTree(), 9));
    }

    public static boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return node.val == sum;

        return hasPathSum(node.left, sum - node.val) || hasPathSum(node.right, sum - node.val);
    }

    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queue.offer(root);
        queueSum.offer(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                int curSum = queueSum.poll();
                if (curSum == sum && node.left == null && node.right == null) return true;
                if (node.left != null) {
                    queue.offer(node.left);
                    queueSum.offer(curSum + node.left.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    queueSum.offer(curSum + node.right.val);
                }
            }
        }
        return false;
    }
}
