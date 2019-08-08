package algorithm.RecursionAndDP;

public class Hanoi {
    public static void main(String[] args) {
        hanoi(3, "A", "B", "C");
    }

    public static void hanoi(int n, String from, String tmp, String to) {
        if(n == 1) {
            System.out.println("Disk 1: " + from + " -> " + to);
            return;
        }
        hanoi(n-1, from, to, tmp);
        hanoi(1, from, tmp, to);
        hanoi(n-1, tmp, from, to);
    }
}
