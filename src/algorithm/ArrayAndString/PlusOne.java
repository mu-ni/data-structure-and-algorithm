package algorithm.ArrayAndString;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne2(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne3(new int[]{1,2,3})));
    }

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int rst[] = new int[digits.length+1];
        for (int i=digits.length-1; i>=0; i--) {
            int sum = digits[i] + carry;
            rst[i+1] = sum%10;
            carry = sum/10;
        }

        if (carry != 0) {
            rst[0] = carry;
            return rst;
        }
        return Arrays.copyOfRange(rst, 1, rst.length);
    }

    public static int[] plusOne2(int[] digits) {
        int[] rst = new int[digits.length];
        int carry = 1;
        for (int i=digits.length-1; i>=0; i--) {
            int sum = digits[i]+carry;
            rst[i] = sum%10;
            carry = sum/10;
        }

        if (carry != 0) {
            int[] newRst = new int[digits.length+1];
            newRst[0] = carry;
            return newRst;
        }
        return rst;
    }

    public static int[] plusOne3(int[] digits) {
        for (int i=digits.length-1; i>=0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] rst = new int[digits.length+1];
        rst[0] = 1;
        return rst;
    }
}
