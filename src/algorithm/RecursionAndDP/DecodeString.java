package algorithm.RecursionAndDP;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString0("2[abc]3[cd]ef"));
        System.out.println(new DecodeString().decodeString("3[2[xyz]4[ab]]ef"));
    }

    // no loop
    public String decodeString0(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder str = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k*10 + (c - '0');
            } else if (c == '[') {
                //
            } else if (c == ']') {
                sb.append(repeat(str.toString(), k));
                str = new StringBuilder();
                k = 0;
            } else {
                str.append(c);
            }
        }
        return sb.append(str).toString();
    }

    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                String str = repeat(cur.toString(), intStack.pop());
                cur = strStack.pop();
                cur.append(str);
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }

    public String repeat(String str, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<k; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
