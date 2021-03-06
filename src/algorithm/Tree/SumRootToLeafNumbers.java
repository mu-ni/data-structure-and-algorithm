package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

/**
 * Created by muni on 2019/12/17
 */
public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        System.out.println(new SumRootToLeafNumbers().sumNumbers(TreeNode.genTree()));
        System.out.println(new SumRootToLeafNumbers().sumNumbers2(TreeNode.genTree()));
        System.out.println(new SumRootToLeafNumbers().sumNumbers3(TreeNode.genTree()));
    }

    int max = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return max;
        dfs(root, 0);
        return max;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) return;
        sum = sum*10 + node.val;
        if (node.left == null && node.right == null) {
            max += sum;
            return;
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
    }

    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int sum) {
        if (node == null) return 0;
        sum = sum*10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return helper(node.left, sum) + helper(node.right, sum);
    }

    public int sumNumbers3(TreeNode root) {
        if (root == null) return 0;
        return helper3(root, 0);
    }

    public int helper3(TreeNode node, int sum) {
        sum = sum*10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }

        int rst = 0;
        if (node.left != null) rst += helper3(node.left, sum);
        if (node.right != null) rst += helper3(node.right, sum);
        return rst;
    }
}
