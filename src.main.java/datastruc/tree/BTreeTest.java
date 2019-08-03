package datastruc.tree;


public class BTreeTest {

	public static void main(String[] args) {
		
//		BinaryTree tree1 = initTree();
//		BTreePrinter.printNode(tree1.root);
		
		System.out.println("Init a binary tree");
		BinaryTree tree2 = insertTree();

		tree2.displayTree();
		
		BTreePrinter.printNode(tree2.root);

//		System.out.println("Print a binary tree");
//		tree2.printTree(tree2.root);
//		System.out.println("");

		TreeNode minNode = tree2.findLeft();
		System.out.println("Left number = " + minNode.getNumber());
		
		TreeNode maxNode = tree2.findRight();
		System.out.println("Right number = " + maxNode.getNumber());
		
		System.out.println("Delete TreeNode 4");
		tree2.delete(new TreeNode(4));		
		BTreePrinter.printNode(tree2.root);
		
		System.out.println("Delete TreeNode 7");
		tree2.delete(new TreeNode(7));		
		BTreePrinter.printNode(tree2.root);
		
		System.out.println("Delete TreeNode 2");
		tree2.delete(new TreeNode(2));		
		BTreePrinter.printNode(tree2.root);

		System.out.println("Delete TreeNode 5");
		tree2.delete(new TreeNode(5));		
		BTreePrinter.printNode(tree2.root);
	}
	
	public static BinaryTree initTree(){
		TreeNode root = new TreeNode(0);
		
		TreeNode child1 = new TreeNode(1);
		TreeNode child2 = new TreeNode(2);
		
		root.leftChild = child1;
		root.rightChild = child2;
		

		TreeNode child11 = new TreeNode(3);
		TreeNode child12 = new TreeNode(4);
		
		child1.leftChild = child11;
		child1.rightChild = child12;
		
		TreeNode child21 = new TreeNode(5);
		TreeNode child22 = new TreeNode(6);
		
		child2.leftChild = child21;
		child2.rightChild = child22;
		
		BinaryTree tree = new BinaryTree();
		tree.root = root;
		
		return tree;
	}
	
	public static BinaryTree insertTree(){
		
		BinaryTree tree = new BinaryTree();
		
		tree.insert(new TreeNode(5));
		tree.insert(new TreeNode(2));
		tree.insert(new TreeNode(8));
		tree.insert(new TreeNode(1));
		tree.insert(new TreeNode(3));
		tree.insert(new TreeNode(7));
		tree.insert(new TreeNode(9));
		tree.insert(new TreeNode(4));
		tree.insert(new TreeNode(6));
		
		return tree;
	}
	
}
