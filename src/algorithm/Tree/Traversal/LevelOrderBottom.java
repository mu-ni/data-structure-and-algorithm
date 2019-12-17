package algorithm.Tree.Traversal;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by muni on 2019/12/17
 */
public class LevelOrderBottom {
    public static void main(String[] args) {
        System.out.println(new LevelOrderBottom().levelOrderBottom(TreeNode.genTree()));
        System.out.println(new LevelOrderBottom().levelOrderBottom2(TreeNode.genTree()));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) return rst;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            rst.add(0, level);
        }
        return rst;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        helper(rst, root, 0);
        return rst;
    }

    public void helper(List<List<Integer>> rst, TreeNode node, int level) {
        if (node == null) return;
        if (rst.size() == level) {
            rst.add(0, new ArrayList<>());
        }
        rst.get(rst.size() - 1 - level).add(node.val);

        helper(rst, node.left, level+1);
        helper(rst, node.right, level+1);
    }
}
