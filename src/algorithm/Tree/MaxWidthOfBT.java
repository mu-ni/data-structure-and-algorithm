package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muni on 2020/1/21
 */
public class MaxWidthOfBT {
    public static void main(String[] args) {
        System.out.println(new MaxWidthOfBT().widthOfBinaryTree(TreeNode.arr2tree(new Integer[]{2,1,4,3,null,5})));
    }

    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> leftIdList = new ArrayList<>(); // left node id
        dfs(root, 0, 0, leftIdList);
        return max;
    }
    private void dfs(TreeNode node, int id, int depth, List<Integer> leftIdList) {
        if (node == null) return;
        if (depth == leftIdList.size()) leftIdList.add(id);
        max = Integer.max(max, id + 1 - leftIdList.get(depth)); // max width
        dfs(node.left,  id * 2 + 1,     depth + 1, leftIdList);
        dfs(node.right, id * 2 + 2, depth + 1, leftIdList);
    }

    // TODO BFS with map(node, id)
    public int widthOfBinaryTree2(TreeNode root) {
        return 0;
    }
}
