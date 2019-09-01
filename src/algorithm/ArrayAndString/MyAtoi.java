package algorithm.ArrayAndString;

public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("9223372036854775808"));
    }

    public int myAtoi(String str) {
        str = str.trim();
        long rst = 0;
        boolean isNeg = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && c == '+') {
                continue;
            }
            if (i == 0 && c == '-') {
                isNeg = true;
                continue;
            }
            if (i == 0 && !Character.isDigit(c)) return 0;
            if (i > 0 && !Character.isDigit(c)) break;

            rst = rst * 10 + Character.getNumericValue(c);
            if (!isNeg && rst > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (isNeg && -rst < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return isNeg ? (int) -rst : (int) rst;
    }
}
