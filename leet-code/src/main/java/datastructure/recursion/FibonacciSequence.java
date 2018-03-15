package datastructure.recursion;

public class FibonacciSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FibonacciSequence().fibonacci(10));
	}

	public int fibonacci(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
