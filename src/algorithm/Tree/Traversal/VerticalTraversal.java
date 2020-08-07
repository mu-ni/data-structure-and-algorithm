package algorithm.Tree.Traversal;

import algorithm.Tree.Dao.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by muni on 2020/8/7
 */
public class VerticalTraversal {
    public static void main(String[] args) {
        System.out.println(new VerticalTraversal().verticalTraversal(TreeNode.arr2tree(new Integer[]{3,9,20,null,null,15,7})));
    }

    public class Node {
        public Integer val;
        public int row;
        public int col;
        public Node (int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Node> list = new ArrayList<>();
        dfs(root, 0, 0, list);
        Comparator<Node> comp = (a, b) -> {
            if (a.col != b.col) {
                return a.col - b.col;
            }
            if (a.row != b.row) {
                return a.row - b.row;
            }
            return a.val - b.val;
        };
        list.sort(comp);
        for (int i=0; i<list.size(); i++) {
            if (i == 0 || list.get(i).col != list.get(i-1).col) {
                rst.add(new ArrayList<>());
            }
            rst.get(rst.size()-1).add(list.get(i).val);
        }
        return rst;
    }

    private void dfs(TreeNode node, int row, int col, List<Node> list) {
        if (node == null) return;
        list.add(new Node(node.val, row, col));
        dfs(node.left, row+1, col-1, list);
        dfs(node.right, row+1, col+1, list);
    }
}
