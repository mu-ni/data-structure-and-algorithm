package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;
import algorithm.Tree.Traversal.PreOrder;

import java.util.*;

public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.arr2tree(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, null, null, 4});
        List<TreeNode> rst = new FindDuplicateSubtrees().findDuplicateSubtrees(tree);
        rst.forEach(i -> System.out.println(new PreOrder().preOrder(i)));

        System.out.println();
        rst = new FindDuplicateSubtrees().findDuplicateSubtrees2(tree);
        rst.forEach(i -> System.out.println(new PreOrder().preOrder(i)));
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<String, TreeNode> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        dfs(root, map, set);
        return new ArrayList<>(map.values());
    }

    public void dfs(TreeNode node, Map<String, TreeNode> map, Set<String> set) {
        if (node == null) return;
        String treeStr = encode(node);
        if (set.contains(treeStr)) map.put(treeStr, node);
        set.add(treeStr);
        dfs(node.left, map, set);
        dfs(node.right, map, set);
    }

    public String encode(TreeNode node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        encode(sb, node);
        return sb.toString();
    }

    public void encode(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(node.val).append(",");
        encode(sb, node.left);
        encode(sb, node.right);
    }

    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> rst = new ArrayList<>();
        helper(root, map, rst);
        return rst;
    }

    public String helper(TreeNode node, Map<String, Integer> map, List<TreeNode> rst) {
        if (node == null) return "#,";
        String str = String.valueOf(node.val) + "," +
                helper(node.left, map, rst) +
                helper(node.right, map, rst);
        int count = map.getOrDefault(str, 0);
        if (count == 1) rst.add(node);
        map.put(str, count + 1);
        return str;
    }
}
