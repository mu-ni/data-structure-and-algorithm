package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
        System.out.println(maxDepth3(root));
        System.out.println(maxDepth4(root));
    }

    public static int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(dfs(node.left, depth+1), dfs(node.right, depth+1));
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) +1;
    }

    public static int maxDepth3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;

                queue.offer(node.left);
                queue.offer(node.right);
            }
            depth++;
        }
        return depth-1;
    }

    public static int maxDepth4(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;

        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
