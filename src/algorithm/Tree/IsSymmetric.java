package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.arr2tree(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(new IsSymmetric().isSymmetric(tree));
        System.out.println(new IsSymmetric().isSymmetric2(tree));
        System.out.println(new IsSymmetric().isSymmetric3(tree));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] level = new Integer[size];
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    level[i] = null;
                } else {
                    level[i] = node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            int start = 0;
            int end = size-1;
            while (start < end) {
                if (level[start] != level[end]) return false;
                start ++;
                end --;
            }
        }
        return true;
    }
}
