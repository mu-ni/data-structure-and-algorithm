package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

public class DeleteNodeInBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        new DeleteNodeInBST().deleteNode(root, 3);
        System.out.println(TreeNode.tree2arr(root));
        root = TreeNode.arr2tree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        new DeleteNodeInBST().deleteNode2(root, 3);
        System.out.println(TreeNode.tree2arr(root));
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode leftMax = root.left;
            while (leftMax.right != null) {
                leftMax = leftMax.right;
            }
            root.val = leftMax.val;
            root.left = deleteNode(root.left, leftMax.val);
        }
        return root;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode2(root.left, key);
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode2(root.right, key);
            return root;
        }
        // key == root.val
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode leftMax = root.left;
        while (leftMax.right != null) {
            leftMax = leftMax.right;
        }
        root.val = leftMax.val;
        root.left = deleteNode2(root.left, leftMax.val);

        return root;
    }
}
