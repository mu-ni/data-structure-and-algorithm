package algorithm.ArrayAndString;

public class ExcelColNumber {
    public static void main(String[] args) {
        System.out.println(new ExcelColNumber().titleToNumber("AZ"));
        System.out.println(new ExcelColNumber().titleToNumber2("AZ"));
    }

    String dict = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public int titleToNumber(String s) {
        int rst = 0;
        for(int i=0; i<s.length(); i++) {
            rst = rst*26 + dict.indexOf(s.charAt(i)) + 1;
        }
        return rst;
    }

    public int titleToNumber2(String s) {
        int rst = 0;
        for(int i=0; i<s.length(); i++) {
            rst = rst*26 + s.charAt(i) - 'A' + 1;
        }
        return rst;
    }
}
