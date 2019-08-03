package datastructure.queue;

public class Queue {

	private int maxSize;
	private int[] queueArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int s){
		this.maxSize = s;
		this.queueArray = new int[maxSize];
		this.front = 0;
		this.rear = -1;
		this.nItems = 0;
	}
	
	public boolean isEmpty(){
		return nItems == 0;
	}
	
	public boolean isFull(){
		return nItems == maxSize;
	}
	
	public void add(int n){
		if(isFull()){
			System.out.println("Error: queue is full");
			return;
		}
		if(rear == maxSize-1){//wrap around
			rear = -1;
		}
		rear ++;
		queueArray[rear] = n;
		nItems ++;		
	}
	
	public int remove(){
		int first = queueArray[front];
		front ++;
		if(front == maxSize){//wrap around
			front = 0;
		}
		nItems --;
		return first;
	}
	
	public int peek(){
		return queueArray[front];
	}
	
	public int size(){
		return nItems;
	}
	
	public void printQueue(){
		System.out.println("Queue(front -> rear): ");
		if(nItems == 0){
			System.out.print("Empty queue");
		}else if(front < rear){
			for(int i=front; i<=rear; i++){
				System.out.print(queueArray[i] + " ");
			}
		}else{//wrap around
			for(int i=front; i<maxSize; i++){
				System.out.print(queueArray[i] + " ");
			}
			for(int i=0; i<=rear; i++){
				System.out.print(queueArray[i] + " ");
			}
		}
		System.out.println();
	}
	
}
