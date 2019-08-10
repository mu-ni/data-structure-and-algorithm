package algorithm.TreeAndGraph.Dao;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public int val;
    public Tree left;
    public Tree right;
    public boolean visited = false;

    public Tree(int val) {
        this.val = val;
    }

    public List<Tree> adjacent() {
        List<Tree> list = new ArrayList<>();
        if (left != null) list.add(left);
        if (right != null) list.add(right);
        return list;
    }

    public static Tree genTree() {
        Tree root = new Tree(4);
        Tree child1 = new Tree(3);
        Tree leaf1 = new Tree(1);
        Tree leaf2 = new Tree(2);
        Tree child2 = new Tree(5);
        Tree leaf3 = new Tree(6);
        Tree leaf4 = new Tree(7);

        root.left = child1;
        root.right = child2;
        child1.left = leaf1;
        child1.right = leaf2;
        child2.left = leaf3;
        child2.right = leaf4;

        return root;
    }

    public static void visit(Tree node) {
        System.out.println(node.val);
    }
}
