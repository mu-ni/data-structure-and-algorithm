package algorithm.amz;

import algorithm.Tree.Dao.TreeNode;

/**
 * Created by muni on 2019/12/9
 */
public class SubtreeMaximumAverage {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{1,-5,13,1,2,4,-2});
        TreeNode subtree = new SubtreeMaximumAverage().subtreeMaxAverage(root);
        System.out.println(TreeNode.tree2arr(subtree));
    }

    TreeNode maxRoot = null;
    int max = Integer.MIN_VALUE;
    public TreeNode subtreeMaxAverage(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return maxRoot;
    }

    public int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0,0};
        int sum = node.val;
        int count = 1;

        sum += dfs(node.left)[0];
        count += dfs(node.left)[1];
        sum += dfs(node.right)[0];
        count += dfs(node.right)[1];

        int avg = sum/count;
        if (avg > max) {
            max = avg;
            maxRoot = node;
        }
        return new int[]{sum, count};
    }
}
