package algorithm.Math;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate0("2-1 + 20"));
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(new BasicCalculator().calculate2("2-1 + 20"));
    }

    // no ()
    public int calculate0(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> oStack = new Stack<>();
        int n = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                n = n*10 + (c - '0');
            } else { // +/-
                if (stack.isEmpty()) {
                    stack.push(n);
                } else {
                    int n1 = stack.pop();
                    char oper = oStack.pop();
                    stack.push(calculate(n1, n, oper));
                }
                oStack.push(c);
                n = 0;
            }
        }

        if (!stack.isEmpty() && !oStack.isEmpty()) {
            int n1 = stack.pop();
            char oper = oStack.pop();
            stack.push(calculate(n1, n, oper));
        }
        return stack.pop();
    }

    private int calculate(int n1, int n2, char oper) {
        switch (oper) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            default:
                System.out.println("error");
        }
        return -1;
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int rst = 0;
        int sign = 1;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int n = c - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    n = n*10 + (s.charAt(i+1) - '0');
                    i ++;
                }
                rst += n*sign;
            } else if (c == '(') {
                stack.push(rst);
                stack.push(sign);
                rst = 0;
                sign = 1;
            } else if (c == ')') {
                rst = rst*stack.pop() + stack.pop();
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            }
        }
        return rst;
    }

    // no ()
    public int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int n = c - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    n = n*10 + (s.charAt(i+1) - '0');
                    i ++;
                }
                if (stack.isEmpty()) {
                    stack.push(n);
                } else {
                    stack.push(stack.pop() + sign*n);
                }
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            }
        }

        return stack.pop();
    }
}
