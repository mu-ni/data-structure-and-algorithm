package design;

import algorithm.Tree.Dao.TreeNode;
import algorithm.Tree.Traversal.PreOrder;

import java.util.*;

// TLE
public class SerializeDeserializeBST2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int nullSize = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    list.add("null");
                    queue.offer(null);
                    queue.offer(null);
                    nullSize++;
                } else {
                    list.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (nullSize == size) break;
        }
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] arr = data.split(",");
        return dfs(arr, 0);
    }

    private TreeNode dfs(String[] arr, int index) {
        if (index >= arr.length) return null;
        if (arr[index].equals("null")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(arr[index]));
        node.left = dfs(arr, 2*index + 1);
        node.right = dfs(arr, 2*index + 2);
        return node;
    }

    public static void main(String[] args) {
        SerializeDeserializeBST2 coder = new SerializeDeserializeBST2();
        String encode = coder.serialize(TreeNode.genTree());
        System.out.println(encode);
        TreeNode decode = coder.deserialize(encode);
        System.out.println(new PreOrder().preOrder(decode));
    }
}
