package design;

import algorithm.Tree.Dao.TreeNode;

import java.util.*;

public class SerDeSerBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        List<String> list = new ArrayList<>();
        buildString(root, list);
        int index = list.size()-1;
        while (list.get(index).equals("null")) {
            list.remove(index--);
        }
        return String.join(", ", list);
    }

    public void buildString(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        buildString(node.left, list);
        buildString(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(", ")));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (val == null || val.equals("null")) return null;

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new SerDeSerBT().deserialize("5, 2, 3, null, null, 2, 4, 3, 1");
        System.out.println(new SerDeSerBT().serialize(tree));
    }
}
