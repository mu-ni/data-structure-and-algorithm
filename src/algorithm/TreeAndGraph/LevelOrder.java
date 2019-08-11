package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        System.out.println(bfs(Tree.genTree()));
    }
    
    public static List<List<Integer>> bfs(Tree root) {
        List<List<Integer>> rst = new LinkedList<>();
        if(root == null) return rst;

        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<level; i++) {
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

    // dfs
}
