package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class MinDiffInBST {
    public static void main(String[] args) {
        System.out.println(new MinDiffInBST().getMinimumDifference(TreeNode.arr2tree(new Integer[]{1,null,3,null,null,2,null})));
    }

    int minDiff = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        if (pre != null) {
            minDiff=Math.min(minDiff, node.val-pre.val);
        }
        pre = node;
        inorder(node.right);
    }
}
