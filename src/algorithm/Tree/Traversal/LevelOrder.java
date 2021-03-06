package algorithm.Tree.Traversal;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        System.out.println(levelOrder(TreeNode.genTree()));
        System.out.println(levelOrder2(TreeNode.genTree()));
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if(root == null) return rst;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;

                level.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (level.size() > 0) {
                rst.add(level);
            }
        }
        return rst;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        helper(rst, root, 0);
        return rst;
    }

    public static void helper(List<List<Integer>> rst, TreeNode node, int level) {
        if (node == null) return;
        if (rst.size() == level) {
            rst.add(new ArrayList<>());
        }
        rst.get(level).add(node.val);

        helper(rst, node.left, level+1);
        helper(rst, node.right, level+1);
    }
}
