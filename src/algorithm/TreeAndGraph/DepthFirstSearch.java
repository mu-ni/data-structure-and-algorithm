package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class DepthFirstSearch {
    public static void main(String[] argd) {
        TreeNode root = TreeNode.genTree();
        dfs(root);
    }

    public static void dfs(TreeNode node) {
        if (node == null) return;
        TreeNode.visit(node);
        node.visited = true;
        for (TreeNode n : node.adjacent()) {
            if (!n.visited) {
                dfs(n);
            }
        }
    }
}
