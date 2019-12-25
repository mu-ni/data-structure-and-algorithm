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
        buildMap(map, null, root);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            if (K == 0) return buildList(queue);
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode next : map.getOrDefault(node, new ArrayList<>())) {
                    if (visited.contains(next)) continue;
                    queue.offer(next);
                    visited.add(next);
                }
            }
            K--;
        }
        return new ArrayList<>();
    }

    public List<Integer> buildList(Queue<TreeNode> queue) {
        List<Integer> rst = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                rst.add(node.val);
            }
        }
        return rst;
    }

    // key -> node, value -> parent & children
    public void buildMap(Map<TreeNode, List<TreeNode>> map, TreeNode parent, TreeNode node) {
        if (node == null) return;
        map.putIfAbsent(parent, new ArrayList<>());
        map.putIfAbsent(node, new ArrayList<>());
        map.get(parent).add(node);
        map.get(node).add(parent);
        buildMap(map, node, node.left);
        buildMap(map, node, node.right);
    }
}
