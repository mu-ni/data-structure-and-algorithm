package datastruc.heap;

public class TestHeapSort {

	public static void main(String[] args) {
		//O(n*logn)

		int size = 20;
		int i;
		System.out.println("Insert " +size+ " random numbers into an array");
		Heap heap = new Heap(size);
		for(i=0; i<size; i++){
			int random = (int) (Math.random()*100);
			Node newNode = new Node(random);
			heap.insertAt(i, newNode);
			heap.incrementSize();
		}
		heap.displayArray();

		System.out.println("Array -> Heap");
		for(i=size/2-1; i>=0; i--){
			heap.trickleDown(i);
		}
		heap.displayHeap();
		
		System.out.println("Sorted array(small -> big):");
		for(i=size-1;i>=0;i--){
			Node biggestNode = heap.remove();
			heap.insertAt(i, biggestNode);
		}
		heap.displayArray();
		
	}

}
