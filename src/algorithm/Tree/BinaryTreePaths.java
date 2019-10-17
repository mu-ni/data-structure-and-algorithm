package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        System.out.println(new BinaryTreePaths().binaryTreePaths(TreeNode.arr2tree(new Integer[]{1,2,3,null,5})));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<>();
        backtrack(rst, root, new ArrayList<>());
        return rst;
    }

    public void backtrack(List<String> rst, TreeNode node, List<String> path) {
        if (node == null) return;
        path.add(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
            rst.add(String.join("->", path));
        } else {
            backtrack(rst, node.left, path);
            backtrack(rst, node.right, path);
        }
        path.remove(path.size()-1);
    }
}
