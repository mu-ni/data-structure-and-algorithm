package datastructure.queue;

public class TestPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Init priority queue");
		PriorityQueue pq = new PriorityQueue(5);
		
		System.out.println("Add 5 items into queue");
		int[] array = {9,4,7,1,3};
		for(int n : array){
			pq.add(n);
		}
		pq.display();
		
		System.out.println("Get the peek of queue");
		int peek = pq.peek();
		System.out.println("Peek: " + peek);
		
		System.out.println("Remove 1 item from the queue");
		int rem = pq.remove();
		pq.display();
		System.out.println("Min value " + rem + " has been removed");	
		
		System.out.println("Add 5 into queue");
		pq.add(5);
		pq.display();		
	}

}
