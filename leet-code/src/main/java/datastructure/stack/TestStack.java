package datastructure.stack;

public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Init a stack");
		Stack stack = new Stack(10);
		
		System.out.println("Push 10 numbers into stack");
		int[] array = {7,4,8,2,1,9,3,6,0,5};
		for(int i : array){
			stack.push(i);
		}
		stack.printStack();
		
		System.out.println("Get the top of stack");
		int peek = stack.peek();
		System.out.println("Top is " + peek);
		stack.printStack();
		
		System.out.println("Pop the top of stack");
		int pop = stack.pop();
		System.out.println(pop + " has been poped");
		stack.printStack();
	}

}
