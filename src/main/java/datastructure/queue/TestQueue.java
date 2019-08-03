package datastructure.queue;

public class TestQueue {

	public static void main(String[] args) {
		
		System.out.println("Init an empty queue");
		Queue queue = new Queue(5);
		queue.printQueue();
		
		System.out.println("Add 5 items into queue");
		int[] array = {9, 4, 5, 7, 2};		
		for(int n : array){
			queue.add(n);
		}
		queue.printQueue();
		
		int front = queue.peek();
		System.out.println("Head value: " + front);
		
		System.out.println("Remove 1 item from queue:");
		int removedVal = queue.remove();
		System.out.println(removedVal + " has been removed");
		queue.printQueue();
		
		System.out.println("Add 3 into queue");
		queue.add(3);
		queue.printQueue();
		
		System.out.println("Remove 2 items from queue:");
		int removedVal1 = queue.remove();
		int removedVal2 = queue.remove();
		System.out.println(removedVal1 + ", " + removedVal2 + " have been removed");
		queue.printQueue();
		
		System.out.println("Add 0, 10 into queue");
		queue.add(0);
		queue.add(10);
		queue.printQueue();
		
		System.out.println("Remove all items from queue:");
		for(int i=0; i<5; i++){
			queue.remove();
		}
		queue.printQueue();
	}
}
