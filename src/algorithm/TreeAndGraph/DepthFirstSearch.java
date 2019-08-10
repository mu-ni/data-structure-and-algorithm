package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.Tree;

public class DepthFirstSearch {
    public static void main(String[] argd) {
        Tree root = Tree.genTree();
        dfs(root);
    }

    public static void dfs(Tree node) {
        if (node == null) return;
        Tree.visit(node);
        node.visited = true;
        for (Tree n : node.adjacent()) {
            if (!n.visited) {
                dfs(n);
            }
        }
    }
}
