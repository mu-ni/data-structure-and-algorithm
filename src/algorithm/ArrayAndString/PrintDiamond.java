package algorithm.ArrayAndString;

public class PrintDiamond {
    public static void main(String[] args) {
        new PrintDiamond().printDiamond(11);
    }

    public void printDiamond(int n) {
        for (int i=0; i<n; i++) {
            for (int k=0; k<n; k++) {
                if (i >=n/3 && i <= n/2 && k >= n/2 - i && k <= n/2 + i) {
                    System.out.print("*");
                    continue;
                }
                if (i > n/2 && k >= n/2 - (n-1-i) && k <= n/2 + (n-1-i)) {
                    System.out.print("*");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
