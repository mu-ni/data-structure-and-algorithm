package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        System.out.println(new FindBottomLeftTreeValue().findBottomLeftValue(TreeNode.genTree()));
        System.out.println(new FindBottomLeftTreeValue().findBottomLeftValue2(TreeNode.genTree()));
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int rst = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    rst = node.val;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return rst;
    }

    int rst = -1;
    int lev = -1;
    public int findBottomLeftValue2(TreeNode root) {
        if (root == null) return -1;
        dfs(root, 1);
        return rst;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level > lev) {
            rst = node.val;
            lev = level;
        }
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}
