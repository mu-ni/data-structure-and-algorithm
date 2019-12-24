package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

/**
 * Created by muni on 2019/12/24
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(TreeNode.arr2tree(new Integer[]{1,4,5,4,4,null,5})));
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int leftMax = helper(root.left, root.val);
        int rightMax = helper(root.right, root.val);
        int max = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        return Math.max(leftMax + rightMax, max);
    }

    public int helper(TreeNode node, int val) {
        if (node == null || node.val != val) return 0;
        return 1 + Math.max(helper(node.left, node.val), helper(node.right, node.val));
    }
}
