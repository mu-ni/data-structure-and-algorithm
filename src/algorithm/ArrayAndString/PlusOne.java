package algorithm.ArrayAndString;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
    }

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int rst[] = new int[digits.length+1];
        for (int i=digits.length-1; i>=0; i--) {
            int sum = digits[i] + carry;
            if (sum > 9) {
                rst[i+1] = sum%10;
                carry = sum/10;
                continue;
            }
            rst[i+1] = sum;
            carry = 0;
        }

        if (carry != 0) {
            rst[0] = carry;
            return rst;
        }
        return Arrays.copyOfRange(rst, 1, rst.length);
    }
}
