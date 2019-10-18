package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

public class HouseRobber3 {
    public static void main(String[] args) {
        System.out.println(new HouseRobber3().rob(TreeNode.arr2tree(new Integer[]{4,1,null,2,null,3})));
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(robInclude(root), robExclude(root));
    }

    public int robInclude(TreeNode node) {
        if (node == null) return 0;
        return node.val + robExclude(node.left) + robExclude(node.right);
    }

    public int robExclude(TreeNode node) {
        if (node == null) return 0;
        return rob(node.left) + rob(node.right);
    }
}
