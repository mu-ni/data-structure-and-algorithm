package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;
import algorithm.Tree.Traversal.PreOrder;

public class MaximumBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        System.out.println(new PreOrder().preOrder(tree));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }


    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);

        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, start, maxIndex-1);
        root.right = helper(nums, maxIndex+1, end);
        return root;
    }

    public int findMaxIndex(int[] nums, int start, int end) {
        int index = start;
        for (int i=start; i<=end; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }
}
