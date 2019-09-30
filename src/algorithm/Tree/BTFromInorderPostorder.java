package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BTFromInorderPostorder {
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode tree = new BTFromInorderPostorder().buildTree(inorder, postorder);
        System.out.println(TreeNode.tree2arr(tree));
        tree = new BTFromInorderPostorder().buildTree2(inorder, postorder);
        System.out.println(TreeNode.tree2arr(tree));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end) {
        if (p_start > p_end) return null;
        if (p_start == p_end) return new TreeNode(postorder[p_start]);

        int root_val = postorder[p_end];
        int i_root_index = 0;
        for (int i = i_start; i <= i_end; i++) {
            if (inorder[i] == root_val) {
                i_root_index = i;
                break;
            }
        }

        int left_len = i_root_index - i_start;
        TreeNode root = new TreeNode(root_val);
        root.left = helper(inorder, i_start, i_root_index -1, postorder, p_start, p_start + left_len - 1);
        root.right = helper(inorder, i_root_index + 1, i_end, postorder, p_start + left_len, p_end - 1);
        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }

    public TreeNode helper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end, Map<Integer, Integer> map) {
        if (p_start > p_end) return null;
        if (p_start == p_end) return new TreeNode(postorder[p_start]);

        int root_val = postorder[p_end];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);
        int left_len = i_root_index - i_start;

        TreeNode left = helper(inorder, i_start, i_root_index-1, postorder, p_start, p_start + left_len-1, map);
        TreeNode right = helper(inorder, i_root_index+1, i_end, postorder, p_start + left_len, p_end-1, map);
        root.left = left;
        root.right = right;

        return root;
    }
}
