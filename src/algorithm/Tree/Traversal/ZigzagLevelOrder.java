package algorithm.Tree.Traversal;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public static void main(String[] args) {
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(TreeNode.genTree()));
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder2(TreeNode.genTree()));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) return rst;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (level%2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
            rst.add(list);
        }

        return rst;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(rst, root, 0);
        return rst;
    }

    public void dfs(List<List<Integer>> rst, TreeNode node, int level) {
        if (node == null) return;
        if (rst.size() <= level) {
            rst.add(new ArrayList<>());
        }
        if (level%2 == 0) {
            rst.get(level).add(node.val);
        } else {
            rst.get(level).add(0, node.val);
        }

        dfs(rst, node.left, level+1);
        dfs(rst, node.right, level+1);
    }
}
