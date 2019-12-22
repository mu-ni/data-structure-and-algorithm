package algorithm.RecursionAndDP;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString0("2[abc]3[cd]ef"));
        System.out.println(new DecodeString().decodeString("3[2[xyz]4[ab]]ef"));
        System.out.println(new DecodeString().decodeString2("3[2[xyz]4[ab]]ef"));
        System.out.println(new DecodeString().decodeString3("3[2[xyz]4[ab]]ef"));
    }

    // no loop
    public String decodeString0(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder str = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
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
        Stack<Integer> istack = new Stack<>();
        Stack<String> stack = new Stack<>();
        int n = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n = n*10 + c - '0';
            } else if (c == '[') {
                istack.push(n);
                n = 0;
                stack.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ']') {
                String str = stack.pop();
                str += repeat(sb.toString(), istack.pop());
                sb = new StringBuilder(str);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String repeat(String str, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public String decodeString2(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<StringBuilder> s2 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n*10 + c - '0';
            } else if (c == '[') {
                s1.push(n);
                n = 0;
                s2.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = sb;
                sb = s2.pop();
                sb.append(repeat(tmp.toString(), s1.pop()));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String decodeString3(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n*10 + c - '0';
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '[') {
                s1.push(n);
                n = 0;
                s2.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ']') {
                String str = s2.pop();
                str += repeat(sb.toString(), s1.pop());
                sb = new StringBuilder(str);
            }
        }
        return sb.toString();
    }
}
