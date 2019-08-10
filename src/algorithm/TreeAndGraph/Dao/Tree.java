package algorithm.TreeAndGraph.Dao;

public class Tree {
    public int val;
    public Tree left;
    public Tree right;

    public Tree(int val) {
        this.val = val;
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
}
