package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IsSubTree {
    public static void main(String[] args) {
        TreeNode s = TreeNode.arr2tree(new Integer[]{1,2});
        TreeNode t = TreeNode.arr2tree(new Integer[]{2});
        System.out.println(isSubtree(s, t));
        System.out.println(isSubtree2(s, t));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (isTheSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static boolean isTheSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;

        return isTheSame(t1.left, t2.left) && isTheSame(t1.right, t2.right);
    }

    public static boolean isSubtree2(TreeNode s, TreeNode t) {
        List<Integer> l1 = preOrder(s, new ArrayList<>());
        List<Integer> l2 = preOrder(t, new ArrayList<>());
        return Collections.indexOfSubList(l1 , l2) > -1;
    }

    public static List<Integer> preOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            list.add(null);
        } else {
            list.add(node.val);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
        return list;
    }
}
