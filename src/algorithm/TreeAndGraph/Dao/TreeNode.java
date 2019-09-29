package algorithm.TreeAndGraph.Dao;

import algorithm.TreeAndGraph.MaxDepthBST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public boolean visited = false;

    public TreeNode(int val) {
        this.val = val;
    }

    public List<TreeNode> adjacent() {
        List<TreeNode> list = new ArrayList<>();
        if (left != null) list.add(left);
        if (right != null) list.add(right);
        return list;
    }

    public static TreeNode genTree() {
        TreeNode root = new TreeNode(4);
        TreeNode child1 = new TreeNode(2);
        TreeNode leaf1 = new TreeNode(1);
        TreeNode leaf2 = new TreeNode(3);
        TreeNode child2 = new TreeNode(6);
        TreeNode leaf3 = new TreeNode(5);
        TreeNode leaf4 = new TreeNode(7);

        root.left = child1;
        root.right = child2;
        child1.left = leaf1;
        child1.right = leaf2;
        child2.left = leaf3;
        child2.right = leaf4;

        return root;
    }

    public static TreeNode arr2tree(Integer[] arr) {
        return dfs(arr, 0);
    }

    private static TreeNode dfs(Integer[] arr, int index) {
        if (index >= arr.length) return null;
        TreeNode node = arr[index] == null ? null : new TreeNode(arr[index]);
        if (node != null) {
            node.left = dfs(arr, 2*index + 1);
            node.right = dfs(arr, 2*index + 2);
        }
        return node;
    }

    public static List<Integer> tree2arr(TreeNode tree) {
        int maxDepth = MaxDepthBST.maxDepth(tree);
        int n = (int) Math.pow(2, maxDepth)-1;

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty() && n-- > 0) {
            TreeNode node = queue.poll();
            list.add(node == null ? null : node.val);
            queue.offer(node == null ? null : node.left);
            queue.offer(node == null ? null : node.right);
        }
        return list;
    }

    public static List<Integer> tree2arrRemoveDupNull(TreeNode tree) {
        int maxDepth = MaxDepthBST.maxDepth(tree);
        int n = (int) Math.pow(2, maxDepth)-1;

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty() && n-- > 0) {
            TreeNode node = queue.poll();
            if (node == null) {
                list.add(null);
                continue;
            }
            list.add(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
        }

        int lastIndex = list.size()-1;
        while (list.size() != 0 && list.get(lastIndex) == null) {
            list.remove(lastIndex);
            lastIndex--;
        }
        return list;
    }

}
