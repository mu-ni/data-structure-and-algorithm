package datastruc.heap;


public class Heap {//O(logn) //root -> max

	private Node[] heapArray;
	private int maxSize;
	private int currentSize;
	
	public Heap(int mx){
		this.maxSize = mx;
		this.currentSize = 0;
		this.heapArray = new Node[mx];
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public boolean insert(int key){
		if(currentSize == maxSize){
			return false;
		}
		
		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize);
		currentSize++;
		
		return true;		
	}
	
	public void trickleUp(int index){
		
		int parent = (index-1)/2;
		Node bottom = heapArray[index];
		while(index >0 && heapArray[parent].getId() < bottom.getId()){
			heapArray[index] = heapArray[parent];//move it down
			index = parent;
			parent = (parent-1)/2;
		}
		heapArray[index] = bottom;		
	}
	
	public Node remove(){
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index){
		int largeChild;
		Node top = heapArray[index];
		
		while(index < currentSize/2){//node has at least 1 child
			int leftChild = 2*index+1;
			int rightChild = leftChild+1;
			
			if(rightChild < currentSize //rightChild exists
					&& heapArray[leftChild].getId() < heapArray[rightChild].getId()){
				largeChild = rightChild;
			}else{
				largeChild = leftChild;
			}
			
			if(top.getId() >= heapArray[largeChild].getId()){
				break;
			}
			
			heapArray[index] = heapArray[largeChild];
			index = largeChild;
		}
		
		heapArray[index] = top;		
	}
	
	public boolean change(int index, int newValue){		
		if(index <0 || index >= currentSize){
			return false;
		}
		
		int oldValue = heapArray[index].getId();
		heapArray[index].setId(newValue);
		
		if(oldValue < newValue){
			trickleUp(index);
		}else{
			trickleDown(index);
		}
		
		return true;
	}
	
	public void insertAt(int index, Node newNode){
		heapArray[index] = newNode;
	}
	
	public void incrementSize(){
		currentSize++;
	}
	
	public void displayArray(){
		for(int i =0; i<maxSize; i++){
			System.out.print(heapArray[i].getId() + " ");
		}
		System.out.println();
	}
	
	public void displayHeap(){
		System.out.println("Display heap array");
		for(int i=0;i<currentSize;i++){
			if(heapArray[i] != null){
				System.out.print(heapArray[i].getId() + " ");
			}else{
				System.out.print("-- ");
			}
		}
		System.out.println();
		
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		
		System.out.println("--------------------------------------------------------------");
		while(currentSize > 0){
			
			if(column == 0){
				for(int k=0;k<nBlanks;k++){
					System.out.print(" ");
				}				
			}
			System.out.print(heapArray[j].getId());
			
			if(++j == currentSize){
				break;
			}
			
			if(++column == itemsPerRow){
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}
			else{
				for(int k=0; k<nBlanks*2-2; k++){
					System.out.print(" ");
				}
			}
		}
		System.out.println("\n--------------------------------------------------------------");
	}
	
}
