package datastruc.tree;

public class TreeNode {
	private String data;
	private int number;
	
	public TreeNode leftChild;
	public TreeNode rightChild;
	
	public TreeNode(String data){
		this.data = data;
	}

	public TreeNode(int number){
		this.number = number;
	}
	
	public String getData() {
		return data;
	}

	public int getNumber() {
		return number;
	}
}
