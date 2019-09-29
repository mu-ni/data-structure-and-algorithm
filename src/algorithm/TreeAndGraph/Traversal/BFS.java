package algorithm.TreeAndGraph.Traversal;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        System.out.println(new BFS().bfs(TreeNode.genTree()));
    }

    public List<Integer> bfs(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            rst.add(node.val);
            node.visited = true;
            for (TreeNode adj : node.adjacent()) {
                if (!adj.visited) {
                    queue.add(adj); // add only unvisited node
                }
            }
        }
        return rst;
    }
}
