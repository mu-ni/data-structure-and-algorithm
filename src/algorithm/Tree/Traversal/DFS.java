package algorithm.Tree.Traversal;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        System.out.println(new DFS().dfs(TreeNode.genTree()));
    }

    public List<Integer> dfs(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        dfs(rst, root);
        return rst;
    }

    public void dfs(List<Integer> rst, TreeNode node) {
        if (node == null) return;
        rst.add(node.val);
        node.visited = true;
        for (TreeNode adj : node.adjacent()) {
            if (!adj.visited) {
                dfs(rst, adj);
            }
        }
    }
}
