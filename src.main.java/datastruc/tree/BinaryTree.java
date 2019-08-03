package datastruc.tree;

import java.util.Stack;

public class BinaryTree {//O(logn)//Level=log2(NodeNumber+1)
	public TreeNode root;
	
	public TreeNode find(TreeNode node){
		TreeNode current = root;
		
		while(current.getNumber() != node.getNumber()){
			if(node.getNumber() < current.getNumber()){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			
			if(current == null){
				System.out.println("Not found");
				return null;
			}
		}
		
		return current;
	};
	
	public void insert(TreeNode newNode){
		if(root == null){
			root = newNode;
		}else{
			TreeNode current = root;
			TreeNode parent;
			
			while(true){
				parent = current;
				if(newNode.getNumber() < current.getNumber()){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = newNode;
						return;
					}
				}else{
					current = current.rightChild;
					if(current == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}		
	};
	
	public TreeNode findLeft(){//min value
		TreeNode current = root;
		TreeNode left = root;
		while(current != null){
			left = current;
			current = current.leftChild;
		}
		return left;
	}
	
	public TreeNode findRight(){//max value
		TreeNode current = root;
		TreeNode right = root;
		while(current != null){
			right = current;
			current = current.rightChild;
		}
		return right;
	}
	
	public void delete(TreeNode node){
		TreeNode current = root;
		TreeNode parent = root;
		boolean isLeftChild = false;
		
		while(current.getNumber() != node.getNumber()){
			parent = current;
			if(current.getNumber() > node.getNumber()){
				current = current.leftChild;
				isLeftChild = true;
			}else{
				current = current.rightChild;
				isLeftChild = false;
			}
		}
		
		if(current.leftChild  == null && current.rightChild == null){
			System.out.println("Delete a leaf node");
			if(current == root){
				System.out.println("Delete a root node");
				root = null;
			}else{
				if(isLeftChild){
					parent.leftChild = null;
				}else{
					parent.rightChild = null;				
				}
			}
		}else if(current.leftChild  != null && current.rightChild != null){
			System.out.println("Delete a node with 2 leaves");
			TreeNode successor = getSuccessor(current);
			if(current == root){
				System.out.println("Delete a root node");
				root = successor;
			}else{
				if(isLeftChild){
					parent.leftChild = successor;
				}else{
					parent.rightChild = successor;
				}
			}
			successor.leftChild = current.leftChild;
		}else{
			if(current.leftChild != null){
				System.out.println("Delete a node with 1 left leaf");
				if(current == root){
					System.out.println("Delete a root node");
					root = current.leftChild;
				}else{
					if(isLeftChild){
						parent.leftChild = current.leftChild;
					}else{
						parent.rightChild = current.rightChild;
					}
				}
			}else{
				System.out.println("Delete a node with 1 right leaf");
				if(current == root){
					System.out.println("Delete a root node");
					root = current.rightChild;
				}else{
					if(isLeftChild){
						parent.leftChild = current.leftChild;
					}else{
						parent.rightChild = current.rightChild;
					}
				}
			}
		}				
	};
	
	private TreeNode getSuccessor(TreeNode node){//get the right node closest to this node value
		TreeNode sucParent = node;
		TreeNode successor = node;
		TreeNode current = node.rightChild;
		
		while(current != null){
			sucParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor != node.rightChild){
			sucParent.leftChild = successor.rightChild;//get susParent also
			successor.rightChild = node.rightChild;
		}
		
		return successor;
	}
	
	public void printTree(TreeNode localRoot){
		if(localRoot != null){
			System.out.print("[");
			printTree(localRoot.leftChild);
			System.out.print(localRoot.getNumber());
			printTree(localRoot.rightChild);
			System.out.print("]");
		}
	}
	
	public void displayTree(){
		System.out.println("Display a binary tree");
		
		Stack<TreeNode> globalStack = new Stack<TreeNode>();
		globalStack.push(root);
		
		int nBlanks = 32;
		boolean isRowEmpty = false;
		
		System.out.println("----------------------------------------------------------------");
		while(!isRowEmpty){
			Stack<TreeNode> localStack = new Stack<TreeNode>();
			isRowEmpty = true;
			
			for(int i=0; i<nBlanks; i++){
				System.out.print(" ");
			}
			
			while(!globalStack.isEmpty()){
				TreeNode temp = globalStack.pop();
				if(temp != null){
					System.out.print(temp.getNumber());
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null || temp.rightChild != null){
						isRowEmpty = false;
					}
				}else{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				
				for(int i=0; i<nBlanks*2-2; i++){
					System.out.print(" ");
				}
			}
			
			System.out.println();
			nBlanks /= 2;
			
			while(!localStack.isEmpty()){
				globalStack.push(localStack.pop());
			}
		}
		System.out.println("----------------------------------------------------------------");		
	}

}
