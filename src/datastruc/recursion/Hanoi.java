package datastruc.recursion;

public class Hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(3, "A", "B", "C");
	}

	public static void hanoi(int n, String from, String temp, String to){
		if(n == 1){
			System.out.println("Disk " + n + ": " + from + " -> " + to);
		}else{
			hanoi(n-1, from, to, temp);
			System.out.println("Disk " + n + ": " + from + " -> " + to);
			hanoi(n-1, temp, from, to);
		}
	}
}
