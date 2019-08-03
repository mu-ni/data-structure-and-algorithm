package test;

public class TestPrint100 {
	public static void main(String[] args) {
		print(100);
	}
	
	private static void print(int n) {
		if(n == 0) {
			return;
		}
		
		print(n-1);
		System.out.println(n);
	}
}
