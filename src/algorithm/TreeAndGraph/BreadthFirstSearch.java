package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] argd) {
        Tree root = Tree.genTree();
        bfs(root);
    }

    public static void bfs(Tree node) {
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            Tree n = queue.poll();
            Tree.visit(n);
            node.visited = true;
            for (Tree adj : n.adjacent()) {
                if (!adj.visited) {
                    queue.add(adj);
                }
            }
        }
    }
}
