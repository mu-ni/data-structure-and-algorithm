package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.*;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = root.left;
        TreeNode q = root.left.right.left;

        TreeNode ancestor = lowestCommonAncestor(root, p, q);
        System.out.println(ancestor == null ? null : ancestor.val);
        ancestor = lowestCommonAncestor2(root, p, q);
        System.out.println(ancestor == null ? null : ancestor.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left == null && right == null) return null;

        return left == null ? right : left;
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        Map<TreeNode, TreeNode> parent = new HashMap<>(); // node - parent map
        Queue<TreeNode> queue = new LinkedList<>(); // level order traversal
        parent.put(root, null);
        queue.add(root);

        while (!(parent.containsKey(p) && parent.containsKey(q))) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }

        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parent.get(p);
        }
        while (!set.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
