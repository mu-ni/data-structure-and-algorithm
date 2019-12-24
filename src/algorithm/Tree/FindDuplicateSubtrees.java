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

        System.out.println();
        rst = new FindDuplicateSubtrees().findDuplicateSubtrees3(tree);
        rst.forEach(i -> System.out.println(new PreOrder().preOrder(i)));
    }

    // TLE
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

    // TLE
    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> rst = new ArrayList<>();
        dfs(map, rst, root);
        return rst;
    }

    public void dfs(Map<String, Integer> map, List<TreeNode> rst, TreeNode root) {
        if (root == null) return;
        String encode = encode(root);
        int count = map.getOrDefault(encode, 0);
        if (count == 1) {
            rst.add(root);
        }
        map.put(encode, count+1);
        dfs(map, rst, root.left);
        dfs(map, rst, root.right);
    }

    public String encode(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val).append(",");
        sb.append(encode(root.left));
        sb.append(encode(root.right));
        return sb.toString();
    }

    public List<TreeNode> findDuplicateSubtrees3(TreeNode root) {
        Set<String> set = new HashSet<>();
        Map<String, TreeNode> map = new HashMap<>();
        encode(set, map, root);
        return new ArrayList<>(map.values());
    }

    public String encode(Set<String> set, Map<String, TreeNode> map, TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            sb.append("#,");
            return sb.toString();
        }

        sb.append(node.val).append(",");
        sb.append(encode(set, map, node.left));
        sb.append(encode(set, map, node.right));
        String str = sb.toString();
        if (set.contains(str)) map.put(str, node);
        set.add(str);
        return sb.toString();
    }
}
