package datastruc.recursion;

import java.util.Stack;

public class Triangle {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(triangle(5));
		System.out.println(triangleRecursion(5));
		System.out.println(triangleStack(5));	
	}
	
	private static void printStar(int n){
		while(n > 0){
			System.out.print("* ");
			n--;
		}
		System.out.println("");
	}
	
	public static int triangle(int n){
		int total = 0;
		while(n > 0){
			printStar(n);
			total += n;
			n--;
		}
		return total;
	}
	
	public static int triangleRecursion(int n){	
		printStar(n);
//		System.out.println("Entering n = " + n);
		if(n == 1){
			return 1;
		}else{
			int temp = n + triangleRecursion(n-1);
//			System.out.println("Returning " + temp);
			return temp;
		}		
	}
	
	public static int triangleStack(int n){
		
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		
		while(n > 0){
			printStar(n);
			stack.push(n);
			n--;
		}
		
		while(!stack.isEmpty()){
			result += stack.pop();
		}
		
		return result;
	}
}
