package datastructure.stack;

public class Stack {
	private int maxSize;
	private int[] stackArray;
	private int top;
	
	public Stack(int s){
		this.maxSize = s;
		this.stackArray = new int[s];
		this.top = -1;
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == maxSize-1;//index start at 0
	}
	
	public void push(int n){
		top++;
		stackArray[top] = n;
	}
	
	public int pop(){
		int peek = stackArray[top];
		top--;
		return peek;
	}
	
	public int peek(){
		return stackArray[top];
	}
	
	public void printStack(){
		System.out.println("Print stack(bottom -> top)");
		for(int i=0; i<=top; i++){
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
	}
	
}
