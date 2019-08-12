package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class SortedArrayToBST {
    public static void main(String[] args) {
        TreeNode tree = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        TreeTraversal.preOrder(tree);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    public static TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid-1);
        node.right = dfs(nums, mid+1, right);
        return node;
    }
}
