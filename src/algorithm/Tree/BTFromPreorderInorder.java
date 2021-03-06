package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.*;

public class BTFromPreorderInorder {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode tree = new BTFromPreorderInorder().buildTree(preorder, inorder);
        System.out.println(TreeNode.tree2arr(tree));
        tree = new BTFromPreorderInorder().buildTree2(preorder, inorder);
        System.out.println(TreeNode.tree2arr(tree));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start > p_end) return null;
        if (p_start == p_end) return new TreeNode(preorder[p_start]);

        int root_val = preorder[p_start];
        int i_root_index = 0;
        for (int i = i_start; i <= i_end; i++) {
            if (inorder[i] == root_val) {
                i_root_index = i;
                break;
            }
        }

        int left_len = i_root_index - i_start;
        TreeNode root = new TreeNode(root_val);
        root.left = helper(preorder, p_start + 1, p_start + left_len, inorder, i_start, i_root_index - 1);
        root.right = helper(preorder, p_start + left_len + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode helper2(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, Map<Integer, Integer> map) {
        if (p_start > p_end) return null;
        if (p_start == p_end) return new TreeNode(preorder[p_start]);

        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);

        int leftNum = i_root_index - i_start;
        TreeNode left = helper2(preorder, p_start + 1, p_start + leftNum, inorder, i_start, i_root_index - 1, map);
        TreeNode right = helper2(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);
        root.left = left;
        root.right = right;
        return root;
    }
}
