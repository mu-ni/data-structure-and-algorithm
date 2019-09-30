package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HasPathSum {
    public static void main(String[] args) {
        System.out.println(hasPathSum(TreeNode.genTree(), 9));
        System.out.println(hasPathSum2(TreeNode.genTree(), 9));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> remQueue = new LinkedList<>();
        remQueue.offer(sum);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                int rem = remQueue.poll();
                if (node.val == rem && node.left == null && node.right == null) return true;
                rem -= node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                    remQueue.offer(rem);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    remQueue.offer(rem);
                }
            }
        }
        return false;
    }
}
