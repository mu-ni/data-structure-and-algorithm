package datastructure.queue;

public class PriorityQueue {

	private int maxSize;
	private int[] queueArray;
	private int nItems;
	
	public PriorityQueue(int s){
		this.maxSize = s;
		this.queueArray = new int[maxSize];
		this.nItems = 0;
	}
	
	public void add(int n){
		if(isFull()){
			System.out.println("Error: queue is full");
			return;
		}
		if(nItems == 0){
			queueArray[nItems] = n;
			nItems ++;
		}else{
			int i;
			for(i=nItems-1; i>=0; i--){
				if(n > queueArray[i]){
					queueArray[i+1] = queueArray[i];
				}else{
					break;
				}
			}
			queueArray[i+1] = n;
			nItems ++;
		}
	}
	
	public int remove(){
		int temp = queueArray[nItems-1];
		nItems --;
		return temp;
	}
	
	public int peek(){//min
		return queueArray[nItems-1];
	}
	
	public boolean isEmpty(){
		return nItems == 0;
	}
	
	public boolean isFull(){
		return nItems == maxSize;
	}
	
	public void display(){
		System.out.println("Priority Queue(big -> small): ");
		if(nItems == 0){
			System.out.println("Empty Queue");
			return;
		}
		for(int i=0; i<nItems; i++){
			System.out.print(queueArray[i] + " ");
		}
		System.out.println();
	}
	
}
