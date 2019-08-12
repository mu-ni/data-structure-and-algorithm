package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        System.out.println(bfs(TreeNode.genTree()));
        System.out.println(dfs(TreeNode.genTree()));
    }
    
    public static List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if(root == null) return rst;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            rst.add(list);
        }
        return rst;
    }

    public static List<List<Integer>> dfs(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) return rst;
        return dfs(rst, root, 0);
    }

    public static List<List<Integer>> dfs(List<List<Integer>> rst, TreeNode node, int level) {
        if (rst.size() <= level) {
            rst.add(new ArrayList<>());
        }
        rst.get(level).add(node.val);
        if (node.left != null) {
            dfs(rst, node.left, level+1);
        }
        if (node.right != null) {
            dfs(rst, node.right, level+1);
        }
        return rst;
    }
}
