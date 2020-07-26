package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumGoodLeafNodesPairs {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arr2tree(new Integer[]{1,2,3,null,4});
        System.out.println(new NumGoodLeafNodesPairs().countPairs(root, 3));
    }

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> leaves = new ArrayList<>();
        helper(root, map, new ArrayList<>(), leaves);
        int count = 0;
        for (int i=0; i<leaves.size(); i++) {
            for (int j=i+1; j<leaves.size(); j++) {
                List<TreeNode> li = map.get(leaves.get(i));
                List<TreeNode> lj = map.get(leaves.get(j));
                for (int k=0; k<Math.min(li.size(), lj.size()); k++) {
                    if (li.get(k) == lj.get(k)) continue;
                    int dist = li.size() - k + lj.size() - k;
                    if (dist <= distance) count++;
                    break;
                }
            }
        }
        return count;
    }

    private void helper(TreeNode node, Map<TreeNode, List<TreeNode>> map, List<TreeNode> path, List<TreeNode> leaves) {
        if (node == null) return;
        List<TreeNode> newPath = new ArrayList<>(path);
        newPath.add(node);
        if (node.left == null && node.right == null) {
            map.put(node, newPath);
            leaves.add(node);
            return;
        }
        helper(node.left, map, newPath, leaves);
        helper(node.right, map, newPath, leaves);
    }
}
