package algorithm.Tree;

import algorithm.Tree.Dao.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muni on 2019/12/30
 */
public class AllElementsIn2BST {
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.arr2tree(new Integer[]{0,-10,10});
        TreeNode root2 = TreeNode.arr2tree(new Integer[]{5,1,7,0,2});
        System.out.println(new AllElementsIn2BST().getAllElements(root1, root2));
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        inorder(l1, root1);
        List<Integer> l2 = new ArrayList<>();
        inorder(l2, root2);
        return merge(l1, l2);
    }

    public void inorder(List<Integer> list, TreeNode node) {
        if (node == null) return;
        inorder(list, node.left);
        list.add(node.val);
        inorder(list, node.right);
    }

    public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> list = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1) < l2.get(i2)) {
                list.add(l1.get(i1));
                i1++;
            } else {
                list.add(l2.get(i2));
                i2++;
            }
        }

        while (i1 < l1.size()) {
            list.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()) {
            list.add(l2.get(i2));
            i2++;
        }
        return list;
    }
}
