package design;

import algorithm.TreeAndGraph.Dao.TreeNode;
import algorithm.TreeAndGraph.TreeTraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }

    public static void main(String[] args) {
        SerializeDeserializeBST coder = new SerializeDeserializeBST();
        String encode = coder.serialize(TreeNode.genTree());
        System.out.println(encode);
        TreeNode decode = coder.deserialize(encode);
        TreeTraversal.preOrder(decode);
    }

}
