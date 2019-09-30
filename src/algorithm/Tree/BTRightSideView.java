package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {
    public static void main(String[] args) {
        System.out.println(new BTRightSideView().rightSideView(TreeNode.arr2tree(new Integer[]{1,2,3,null,5,null,4})));
        System.out.println(new BTRightSideView().rightSideView2(TreeNode.arr2tree(new Integer[]{1,2,3,null,5,null,4})));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        dfs(rst, root, 0);
        return rst;
    }

    public void dfs(List<Integer> rst, TreeNode node, int level) {
        if (node == null) return;
        if (level == rst.size()) {
            rst.add(node.val);
        }
        dfs(rst, node.right, level+1);
        dfs(rst, node.left, level+1);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) return rst;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (i == size-1) {
                    rst.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return rst;
    }
}
