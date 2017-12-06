package datastructure.heap;

public class TestHeap {

	public static void main(String[] args) {
		
		Heap heap = new Heap(10);
		
		System.out.println("Insert 10 numbers into heap");
		for(int i=1; i<=10; i++){
			boolean isSuccess = heap.insert(i);
			if(isSuccess){
				System.out.println("Insert " + i + " successfully");
			}else{
				System.out.println("Error!: Heap is full");
				break;
			}
		}		
		heap.displayHeap();
		
		System.out.println("Remove root");
		Node delNode = heap.remove();
		System.out.println(delNode.getId() + " has been removed");
		heap.displayHeap();		

		System.out.println("Change index 5 to 12");
		boolean isSuccess = heap.change(5, 12);
		if(isSuccess){
			System.out.println("Change index 5 to 12 successfully");
		}else{
			System.out.println("Error!: index < 0 or index > heap size");
		}
		heap.displayHeap();
	}

}
