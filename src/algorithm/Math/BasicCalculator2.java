package algorithm.Math;

import java.util.Stack;

public class BasicCalculator2 {
    public static void main(String[] args) {
        System.out.println(new BasicCalculator2().calculate("3+5 / 2"));
        System.out.println(new BasicCalculator2().calculate2("3+5 / 2"));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> oStack = new Stack<>();
        // 计算乘除法，并且-1 -> +(-1)
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int n = c - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    n = n*10 + (s.charAt(i+1) - '0');
                    i++;
                }
                if (!stack.isEmpty() && (oStack.peek() == '*' || oStack.peek() == '/')) {
                    int n1 = stack.pop();
                    stack.push(calculate(n1, n, oStack.pop()));
                } else if (!stack.isEmpty() && oStack.peek() == '-') {
                    stack.push(-n);
                    oStack.pop();
                    oStack.push('+');
                } else {
                    stack.push(n);
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                oStack.push(c);
            }
        }

        while (!oStack.isEmpty()) {
            int n2 = stack.pop();
            int n1 = stack.pop();
            stack.push(calculate(n1, n2, oStack.pop()));
        }
        return stack.pop();
    }

    private int calculate(int n1, int n2, char oper) {
        switch (oper) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
            default:
                System.out.println("error");
        }
        return -1;
    }

    public int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        char sign = '+';
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n = n*10 + (c - '0');
            }
            if (i == s.length() - 1 || (c != ' ' && !Character.isDigit(c))) {
                if (sign == '+') {
                    stack.push(n);
                } else if (sign == '-') {
                    stack.push(-n);
                } else if (sign == '*') {
                    stack.push(stack.pop()*n);
                } else if (sign == '/') {
                    stack.push(stack.pop()/n);
                }
                sign = c;
                n = 0;
            }

        }

        int rst = 0;
        for (int num : stack) {
            rst += num;
        }
        return rst;
    }
}
