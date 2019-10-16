package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{0,2,1,null,null,3});
        System.out.println(new AllNodesDistanceKInBinaryTree().distanceK(root, root.right.left, 3));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        buildMap(root, null, map);
        if (!map.containsKey(target)) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            if (K == 0) return buildList(queue);
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                for (TreeNode node : map.getOrDefault(cur, new ArrayList<>())) {
                    if (visited.contains(node)) continue;
                    queue.offer(node);
                    visited.add(node);
                }
            }
            K--;
        }
        return new ArrayList<>();
    }

    public List<Integer> buildList(Queue<TreeNode> queue) {
        List<Integer> rst = new ArrayList<>();
        int size = queue.size();
        for (int i=0; i<size; i++) {
            TreeNode node = queue.poll();
            if (node != null) {
                rst.add(node.val);
            }
        }
        return rst;
    }

    // key -> node, value -> parent & children
    public void buildMap(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> map) {
        if (node == null || map.containsKey(node)) return;
        map.putIfAbsent(parent, new ArrayList<>());
        map.putIfAbsent(node, new ArrayList<>());
        map.get(node).add(parent);
        map.get(parent).add(node);
        buildMap(node.left, node, map);
        buildMap(node.right, node, map);
    }
}
