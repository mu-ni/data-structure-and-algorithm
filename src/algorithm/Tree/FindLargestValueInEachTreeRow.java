package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        System.out.println(new FindLargestValueInEachTreeRow().largestValues(TreeNode.genTree()));
        System.out.println(new FindLargestValueInEachTreeRow().largestValues2(TreeNode.genTree()));
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> rst = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            rst.add(max);
        }
        return rst;
    }

    public List<Integer> largestValues2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> rst = new ArrayList<>();
        dfs(rst, root, 1);
        return rst;
    }

    public void dfs(List<Integer> rst, TreeNode node, int level) {
        if (node == null) return;
        if (rst.size() < level) {
            rst.add(node.val);
        } else {
            rst.set(level-1, Math.max(node.val, rst.get(level-1)));
        }

        dfs(rst, node.left, level+1);
        dfs(rst, node.right, level+1);
    }
}
