package datastruc.recursion;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
	}

	public static int factorial(int n){
		if(n == 0){
			return 1;
		}else{
			return n*factorial(n-1);
		}
	}
}
