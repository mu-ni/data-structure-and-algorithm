package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

/**
 * Created by muni on 2019/12/19
 */
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        System.out.println(new CountCompleteTreeNodes().countNodes(TreeNode.arr2tree(new Integer[]{1,2,3,4,5,6})));
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) return (int) (Math.pow(2, leftHeight)-1);
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int getLeftHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + getLeftHeight(node.left);
    }
    public int getRightHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + getRightHeight(node.right);
    }
}
