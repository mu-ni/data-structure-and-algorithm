package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        System.out.println(bfs(Tree.genTree()));
        System.out.println(dfs(Tree.genTree()));
    }
    
    public static List<List<Integer>> bfs(Tree root) {
        List<List<Integer>> rst = new ArrayList<>();
        if(root == null) return rst;

        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++) {
                Tree node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            rst.add(list);
        }
        return rst;
    }

    public static List<List<Integer>> dfs(Tree root) {
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) return rst;
        return dfs(rst, root, 0);
    }

    public static List<List<Integer>> dfs(List<List<Integer>> rst, Tree node, int level) {
        if (rst.size() < level+1) {
            rst.add(new ArrayList<>());
        }
        rst.get(level).add(node.val);
        if (node.left != null) {
            dfs(rst, node.left, level+1);
        }
        if (node.right != null) {
            dfs(rst, node.right, level+1);
        }
        return rst;
    }
}
