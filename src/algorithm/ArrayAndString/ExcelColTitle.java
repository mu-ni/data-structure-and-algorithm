package algorithm.ArrayAndString;

public class ExcelColTitle {
    public static void main(String[] args) {
        System.out.println(new ExcelColTitle().convertToTitle(52));
        System.out.println(new ExcelColTitle().convertToTitle2(52));
    }

    String dict = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n--;
            sb.insert(0, dict.charAt(n%26));
            n /= 26;
        }
        return sb.toString();
    }

    public String convertToTitle2(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n--;
            sb.insert(0, (char)('A' + n%26));
            n /= 26;
        }
        return sb.toString();
    }
}
