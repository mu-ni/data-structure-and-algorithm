package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode ancestor = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(7));
        System.out.println(ancestor == null ? null : ancestor.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.val == root.val || q.val == root.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
