package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(minDepth(root));
        System.out.println(minDepth2(root));
    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;

        if (root.left == null) {
            return minDepth(root.right)+1;
        }
        if (root.right == null) {
            return minDepth(root.left)+1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static int minDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;

        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth+1;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
