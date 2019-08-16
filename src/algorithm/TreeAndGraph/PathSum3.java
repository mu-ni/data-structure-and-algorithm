package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class PathSum3 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(pathSum(root, 8));
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int dfs(TreeNode node, int sum) {
        if (node == null) return 0;
        sum -= node.val;
        if (sum == 0) {
            return 1 + dfs(node.left, sum) + dfs(node.right, sum);
        }
        return dfs(node.left, sum) + dfs(node.right, sum);
    }
}
