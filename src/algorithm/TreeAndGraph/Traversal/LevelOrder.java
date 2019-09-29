package algorithm.TreeAndGraph.Traversal;

import algorithm.TreeAndGraph.Dao.TreeNode;

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
        dfs(rst, 0, root);
        return rst;
    }

    public static void dfs(List<List<Integer>> rst, int level, TreeNode node) {
        if(node == null) return;

        if (rst.size() <= level) {
            rst.add(new ArrayList<>());
        }
        rst.get(level).add(node.val);

        dfs(rst, level+1, node.left);
        dfs(rst, level+1, node.right);
    }
}
