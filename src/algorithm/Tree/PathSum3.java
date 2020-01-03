package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

public class PathSum3 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(new PathSum3().pathSum(root, 8));
        System.out.println(new PathSum3().pathSum2(root, 8));
    }

    // does not need to start or end at the root or a leaf
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int helper(TreeNode node, int rem) {
        if (node == null) return 0;
        if (node.val == rem) {
            return 1 + helper(node.left, rem-node.val) + helper(node.right, rem-node.val);
        }
        return helper(node.left, rem-node.val) + helper(node.right, rem-node.val);
    }

    int count = 0;
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        dfs(root, sum);
        pathSum2(root.left, sum);
        pathSum2(root.right, sum);
        return count;
    }

    public void dfs(TreeNode node, int rem) {
        if (node == null) return;
        if (node.val == rem) {
            count++;
        }
        dfs(node.left, rem - node.val);
        dfs(node.right, rem - node.val);
    }
}
