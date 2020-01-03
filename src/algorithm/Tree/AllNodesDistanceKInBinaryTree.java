package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{0,2,1,null,null,3});
        System.out.println(new AllNodesDistanceKInBinaryTree().distanceK(root, root.right.left, 3));
        System.out.println(new AllNodesDistanceKInBinaryTree().distanceK2(root, root.right.left, 3));
        System.out.println(new AllNodesDistanceKInBinaryTree().distanceK3(root, root.right.left, 3));
    }

    // BFS from target
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

    public List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, Integer> map = new HashMap<>();
        findDist(map, root, target);
        List<Integer> rst = new ArrayList<>();
        dfs(rst, map, root, K, map.get(root));
        return rst;
    }

    // root && target same branch -> key -> node, value -> dist from target
    public void findDist(Map<TreeNode, Integer> map, TreeNode node, TreeNode target) {
        if (node == null) return;
        if (node == target) {
            map.put(node, 0);
        }
        findDist(map, node.left, target);
        if (map.containsKey(node.left)) {
            map.put(node, map.get(node.left) + 1);
        }
        findDist(map, node.right, target);
        if (map.containsKey(node.right)) {
            map.put(node, map.get(node.right) + 1);
        }
    }

    public void dfs(List<Integer> rst, Map<TreeNode, Integer> map, TreeNode node, int K, int dist) {
        if (node == null) return;
        dist = map.getOrDefault(node, dist);
        if (dist == K) rst.add(node.val);
        dfs(rst, map, node.left, K, dist+1);
        dfs(rst, map, node.right, K, dist+1);
    }

    public List<Integer> distanceK3(TreeNode root, TreeNode target, int K) {
        if (root == null) return new ArrayList<>();
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        buildMap(map, null, root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                for (TreeNode next : map.getOrDefault(cur, new ArrayList<>())) {
                    if (next == null || set.contains(next)) continue;
                    set.add(next);
                    queue.offer(next);
                }
            }
            if (K == 0) return list;
            K--;
        }
        return new ArrayList<>();
    }

    // NOT WORK
//    int targetDist = 0;
//    public List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {
//        if (root == null) return new ArrayList<>();
//        if (K == 0) return new ArrayList<>(Collections.singletonList(target.val));
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        buildMap(map, root, target, 0);
//        List<Integer> rst = new ArrayList<>();
//        for (Integer i : map.getOrDefault(targetDist + K, new ArrayList<>())) {
//            if (i != target.val && isSameBranch(root, i, target.val)) rst.add(i);
//        }
//        for (Integer i : map.getOrDefault(K - targetDist, new ArrayList<>())) {
//            if (i != target.val && !isSameBranch(root, i, target.val)) rst.add(i);
//        }
//        for (Integer i : map.getOrDefault(targetDist - K, new ArrayList<>())) {
//            if (i != target.val && isSameBranch(root, i, target.val)) rst.add(i);
//        }
//        List<Integer> left = distanceK2(root.left, target, K);
//        rst.addAll(left);
//        List<Integer> right = distanceK2(root.right, target, K);
//        rst.addAll(right);
//        return rst;
//    }
//
//    // key -> dist, value -> node value list
//    public void buildMap(Map<Integer, List<Integer>> map, TreeNode node, TreeNode target, int dist) {
//        if (node == null) return;
//        map.putIfAbsent(dist, new ArrayList<>());
//        map.get(dist).add(node.val);
//        if (node.val == target.val) targetDist = dist;
//        buildMap(map, node.left, target, dist+1);
//        buildMap(map, node.right, target, dist+1);
//    }
//
//    public boolean isSameBranch(TreeNode root, int a, int b) {
//        if (root == null) return false;
//        if (a == root.val || b == root.val) return true;
//        boolean left = isSameBranch(root.left, a, b);
//        boolean right = isSameBranch(root.right, a, b);
//        if (!left && !right || left && right) return false;
//        return true;
//    }
}
