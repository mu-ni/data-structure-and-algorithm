package algorithm.Math;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate0("2-1 + 20"));
//        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
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
}
