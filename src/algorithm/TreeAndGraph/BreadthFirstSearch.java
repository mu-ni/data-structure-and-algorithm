package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        TreeNode root = TreeNode.genTree();
        bfs(root);
    }

    public static void bfs(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            TreeNode n = queue.poll();
            TreeNode.visit(n);
            node.visited = true;
            for (TreeNode adj : n.adjacent()) {
                if (!adj.visited) {
                    queue.add(adj); // add only unvisited node
                }
            }
        }
    }
}
