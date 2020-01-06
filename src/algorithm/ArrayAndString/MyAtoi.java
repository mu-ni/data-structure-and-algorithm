package algorithm.ArrayAndString;

public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("+1"));
        System.out.println(new MyAtoi().myAtoi2("+1"));
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

    public int myAtoi2(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;

        long rst = 0;
        int sign = 1;
        int index = 0;
        if (!Character.isDigit(str.charAt(0))) {
            if (str.charAt(0) == '-') {
                sign = -1;
                index = 1;
            } else if (str.charAt(0) == '+') {
                sign = 1;
                index = 1;
            } else {
                return 0;
            }
        }
        while (index < str.length()) {
            char c = str.charAt(index);
            if (!Character.isDigit(c)) break;
            rst = rst*10 + c - '0';
            if (sign*rst > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign*rst < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            index++;
        }
        return (int) (sign*rst);
    }
}
